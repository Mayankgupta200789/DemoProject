package create

import java.io.{BufferedWriter, File, FileWriter}

import scala.io.Source

class RPTAckCreator(kpName: String ) {

  var header : String = "<EncounterResponse>\n    <FileDetail>\n        <FileID>SampleFileID</FileID>\n        <FileName>M444000_837P_0328_2019_1.dat</FileName>\n        <UserID>temp@temp.com</UserID>\n        <ContractProgram>MEDAL4</ContractProgram>\n        <ServiceCenter>M444</ServiceCenter>\n        <SenderID>M444007</SenderID>\n        <SubmittedDate>20190328</SubmittedDate>\n        <SubmittedTime>201823</SubmittedTime>\n        <BatchControlNumber>808011117</BatchControlNumber>\n        <FileSize>3204</FileSize>\n        <TransactionType>837P</TransactionType>\n        <EPSProcessTimeStamp>2018-08-01T20:18:45.487580</EPSProcessTimeStamp>\n        <EncounterCount>{totalEncounters}</EncounterCount>\n        <ComplianceRejectCount>0</ComplianceRejectCount>\n        <ValidationDetail>\n            <ValidationCount>{totalEncounters}</ValidationCount>\n            <ValidationPASSCount>{Accept}</ValidationPASSCount>\n            <ValidationFAILCount>{Reject}</ValidationFAILCount>\n        </ValidationDetail>\n    </FileDetail>\n";
  val FOOTER : String = "\n</EncounterResponse>"
  val STATUS : String = "{STATUS}"

  def create(acceptPercentage : Int, ackType : String): Unit = {


    val path: String = getClass.getResource("../claim/" + kpName + "/" + ackType + "Accept.dat").getPath

    val inputFile = new File(path)


    var temp = ""
    var claimId:Int = 844600124
    var memberId: Long = 1235687890L
    val MEMBER_ID = "{rand_2_n:12}"
    val CLAIM_ID = "{cl_0}"

    val outputPath: String = getClass.getResource("../output").getPath
    val outputFile : File = new File(outputPath + "/" + kpName + "/" + ackType + ".dat")
    val listOfEncountersInputFile : File = new File(outputPath + "/" + kpName + "/" + "EncounterIDList" + ".txt")

    val listOfEncounters = Source.fromFile(listOfEncountersInputFile).getLines().length

    var accept :Int = listOfEncounters.toInt *(acceptPercentage / 100 )
    var reject :Int = listOfEncounters.toInt *{(100 - acceptPercentage) / 100 }

    if(!outputFile.exists()) outputFile.createNewFile()
    val bw = new BufferedWriter(new FileWriter(outputFile))
    header = header.replace("{totalEncounters}",listOfEncounters.toString)
    header = header.replace("{Accept}",accept.toString)
    header = header.replace("{Reject}",reject.toString)
    bw.write(header)



      for(index  <- 0 until listOfEncounters) {

        val source = Source.fromFile(inputFile)
        for (lines <- source.getLines()) {

          temp = lines
          if(lines.contains(STATUS)) {
            if(accept != 0 )  {
              temp = lines.replace(STATUS,"PASS")
              accept = accept - 1
            } else if ( reject != 0 ) {
              temp = lines.replace(STATUS,"FAIL")
              reject = reject - 1
            } else if ( accept == 0 && reject == 0 ) {
              temp = lines.replace(STATUS,"PASS")
            }
            bw.write(temp)
            bw.write("\n")
          }
        }
      }
      bw.write(FOOTER)
      bw.close()
  }

  def createReject(numberOfClaims: Int, numberOfFiles: Int, ackType: String): Unit = {


    val path: String = getClass.getResource("../claim/" + kpName + "/" + ackType + "Reject.dat").getPath

    val inputFile = new File(path)


    var temp = ""
    var claimId:Int = 844600124
    var memberId: Long = 1235687890L
    val MEMBER_ID = "{rand_2_n:12}"
    val CLAIM_ID = "{cl_0}"

    for(l <- 0 until numberOfFiles ) {

      val outputPath: String = getClass.getResource("../output").getPath
      val outputFile : File = new File(outputPath + "/" + kpName + "/" + ackType + l + ".dat")
      if(!outputFile.exists()) outputFile.createNewFile()
      val bw = new BufferedWriter(new FileWriter(outputFile))
      bw.write("00,EMCSV,1.5.3,BatchID,Medical,20160101,S-VA Source,S-VA")
      bw.write("\n")

      for(index  <- 0 until numberOfClaims) {

        val source = Source.fromFile(inputFile)
        for (lines <- source.getLines()) {

          temp = lines
          if(lines.contains(CLAIM_ID)) {
            claimId += 1
            temp = lines.replace(CLAIM_ID,claimId.toString)
          }

          if(lines.contains(MEMBER_ID)) {
            memberId += 1
            temp = lines.replace(MEMBER_ID,memberId.toString)
          }

          bw.write(temp)
          bw.write("\n")
        }
      }

      bw.write("01,TRT,1,0,0,1")
      bw.close()
    }

  }

}
