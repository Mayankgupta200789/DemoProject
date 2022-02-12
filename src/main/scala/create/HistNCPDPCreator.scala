//package create
//
//class HistNCPDPCreator {
//
//  val kpName : String
//
//  def create(acceptPercentage : Int, ackType : String): Unit = {
//
//
//    val path: String = getClass.getResource("../claim/" + kpName + "/" + "https://ecsvn01.corp.edifecs.com/engineering/apps/Financial/RRM/QA/AutomatedTests/VA/NONDUAL/MEDICAL/13.ResubmissionHistorical/837P/10.AdjMultipleAccUpdate .dat").getPath
//
//    val inputFile = new File(path)
//
//
//    var temp = ""
//    var claimId:Int = 844600124
//    val CLAIM_ID = "{cl_0}"
//
//    val outputPath: String = getClass.getResource("../output").getPath
//    val outputFile : File = new File(outputPath + "/" + kpName + "/" + ackType + ".dat")
//    val listOfEncountersInputFile : File = new File(outputPath + "/" + kpName + "/" + "EncounterIDList" + ".txt")
//
//    val listOfEncounters = Source.fromFile(listOfEncountersInputFile).getLines().length
//
//    val encounterIdLines = Source.fromFile(listOfEncountersInputFile).getLines()
//
//    var accept :Int = listOfEncounters.toInt *(acceptPercentage / 100 )
//    var reject :Int = listOfEncounters.toInt *{(100 - acceptPercentage) / 100 }
//
//    if(!outputFile.exists()) outputFile.createNewFile()
//    val bw = new BufferedWriter(new FileWriter(outputFile))
//    bw.write(header)
//    val source = Source.fromFile(inputFile)
//    val linesInInputAck = source.getLines()
//
//    var encounterId : String = "pharmClaimId"
//    var sql = "SELECT trackingidentifier FROM rrmencounter\nwhere claimtypeid = '3000'\nAND receiptdt > '2019-03-30 08:41:00.000'"
//    val outputEncounterList = EncounterListRetriever.retrieve(sql)
//
//    for(index  <- 0 until listOfEncounters) {
//
//
//      input.replace("{cl_0}","0000HJV800")
//    }
//    bw.write(footer)
//    bw.close()
//  }
//
//}
