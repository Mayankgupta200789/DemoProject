package create

import java.io.{BufferedWriter, File, FileWriter}

import scala.io.Source

class NCPDPAckCreator {

  var kpName = "VA"
  val header: String = "\u000200TM444006                 0166680201807111600T125148010900              \u0003"
  var input : String = "\u0002G1{cl_0}D0B1DRVAPROD  1011417050352     20180201          \u001E\u001CAM01\u001CC420180701\u001CCX99\u001CCY1803237518292050011\u001CC52\u001CCBSPENCE\u001CC700\u001C2C1\u001CHNDREC-20180201 DADJ-20180201 DPYM-20180228 PYMS-P\u001C4X01\u001E\u001CAM04\u001CC2145010928034A\u001CCCKIRSTEN\u001CCDSPENCE\u001D\u001E\u001CAM07\u001CEM1\u001CD2000001205890\u001CE103\u001CD765862001105\u001CE70000030000\u001CD303\u001CD5030\u001CD61\u001CD80\u001CDE20171031\u001CC80\u001CE226643006\u001E\u001CAM03\u001CEZ01\u001CDB1366420853\u001CDREDMONSON\u001CPM8048938656\u001C2JSUPAKUNYA\u001C2K5855 BREMO RD\u001C2MRICHMOND\u001C2NVA\u001C2P232261922\u001E\u001CAM11\u001CD90000023G\u001CDC0000010{\u001CDX0000000{\u001CDQ0000269I\u001CDU0000033G\u001CDN01\u001E\u001CAM05\u001C4C1\u001C5C01\u001C6C99\u001C7CM444006\u001CE820180228\u001CHB1\u001CHC07\u001CDV0000033G\u001CA71803237518292050011\u0003"
  val footer: String = "\u00029901666800000000003                                   \u0003"

  def create(acceptPercentage : Int, ackType : String): Unit = {


    val path: String = getClass.getResource("../claim/" + kpName + "/" + "NCPDPInput.dat").getPath

    val inputFile = new File(path)


    var temp = ""
    var claimId:Int = 844600124
    val CLAIM_ID = "{cl_0}"

    val outputPath: String = getClass.getResource("../output").getPath
    val outputFile : File = new File(outputPath + "/" + kpName + "/" + ackType + ".dat")
    val listOfEncountersInputFile : File = new File(outputPath + "/" + kpName + "/" + "EncounterIDList" + ".txt")

    val listOfEncounters = Source.fromFile(listOfEncountersInputFile).getLines().length

    val encounterIdLines = Source.fromFile(listOfEncountersInputFile).getLines()

    var accept :Int = listOfEncounters.toInt *(acceptPercentage / 100 )
    var reject :Int = listOfEncounters.toInt *{(100 - acceptPercentage) / 100 }

    if(!outputFile.exists()) outputFile.createNewFile()
    val bw = new BufferedWriter(new FileWriter(outputFile))
    bw.write(header)
    val source = Source.fromFile(inputFile)
    val linesInInputAck = source.getLines()

    var encounterId : String = "pharmClaimId"
    var sql = "SELECT trackingidentifier FROM rrmencounter\nwhere claimtypeid = '3000'\nAND receiptdt > '2019-03-30 08:41:00.000'"
    val outputEncounterList = EncounterListRetriever.retrieve(sql)

    for(index  <- 0 until listOfEncounters) {


      input.replace("{cl_0}","0000HJV800")
    }
    bw.write(footer)
    bw.close()
  }

}
