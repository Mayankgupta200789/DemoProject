package create

import java.io.{BufferedWriter, File, FileWriter}

import scala.io.Source

class ClaimCreator(kpName: String ) {

  def create(numberOfClaims: Int, numberOfFiles: Int, claimType: String): Unit = {


    val path: String = getClass.getResource("../claim/" + kpName + "/" + claimType + ".dat").getPath

    val inputFile = new File(path)


    var temp = ""
    var claimId:Int = 844610124
    var memberId: Long = 12356878000L
    val MEMBER_ID = "{rand_2_n:11}"
    val CLAIM_ID = "{cl_0}"

    for(l <- 0 until numberOfFiles ) {

      val outputPath: String = getClass.getResource("../output").getPath
      val outputFile : File = new File(outputPath + "/" + kpName + "/" + claimType + l + ".dat")
      if(!outputFile.exists()) outputFile.createNewFile()
      val bw = new BufferedWriter(new FileWriter(outputFile))
      bw.write("00,EMCSV,1.5.3,FileID,Medical,20150101,S-WV Source,S-WV")
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

      bw.write("01,TRT," + numberOfClaims + ",0,0," + numberOfClaims)
      bw.close()
    }

  }

}
