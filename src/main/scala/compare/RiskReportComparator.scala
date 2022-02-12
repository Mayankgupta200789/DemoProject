package compare

class RiskReportComparator {

  var header = "1REPORT   : RAPS408  **ICD10**                  RISK ADJUSTMENT PROCESSING SYSTEM                                  PAGE:        1    \r\n RUN DATE : 20200417                        CORRECTED 408, 409 & 410 EDIT CODE REPORT                        TRANS DATE: 20100102    \r\n0SUBMITTER ID   SH9855    FILE ID:               PLAN ID: H3404    BATCH NUMBER: 0000000                                             \r\n0SEQ     SEQ  PATIENT CONTROL  BENE         BENE          DOB PRVD FROM     THRU     DEL DGNS    DGNS DGNS MAEA MAEA SUBMITTED       \r\n         ERR  ID               ID           ERR  DOB      ERR TYPE DATE     DATE     IND CODE    ERR1 ERR2 CD   ERR  DATE            \r\n                                                                                                                                     "

  var footer = "0                                              ************  END OF FILE ************                                                "

//  def compare(oldFile: String,newFile: String): Unit = {
//
//    val oldFilePath: String = getClass.getResource("../raps/riskreport/" + oldFile + ".dat").getPath
//    val oldInputFile = new File(oldFilePath)
//
//    val newFilePath : String = getClass.getResource("../raps/riskreport/" + newFile + ".dat").getPath
//    val newInputFile = new File(newFilePath)
//
//    val outputPath: String = getClass.getResource("../output").getPath
//    val outputFile : File = new File(outputPath + "/raps/" + "diff.dat")
//
//    if(!outputFile.exists()) outputFile.createNewFile()
//
//    val bw : BufferedWriter = new BufferedWriter(new FileWriter(outputFile))
//
//    val oldSource = Source.fromFile(oldInputFile)
//    val newSource = Source.fromFile(newInputFile)
//    var isCorrectionReport = false
//
//    val oldHashMap: java.util.HashMap[String, util.HashSet[String]] = new util.HashMap[String, util.HashSet[String]]()
//    val newHashMap: java.util.HashMap[String, util.HashSet[String]] = new util.HashMap[String, util.HashSet[String]]()
//
//    for (lines <- oldSource.getLines()) {
//
//      if (lines != null && lines.length > 0) {
//        if (!isCorrectionReport) isCorrectionReport = lines.startsWith("1REPORT   : RAPS408")
//
//        val recordPrefix = getSubStr(lines, 1, 8)
//
//        if (isCorrectionReport && StringUtils.isNotBlank(recordPrefix) && recordPrefix.matches("[0-9]{7}")) {
//          val memberId = getSubStr(lines, 31, 44)
//          if (oldHashMap.containsKey(memberId)) {
//            val oldLines: util.HashSet[String] = oldHashMap.get(memberId)
//            oldLines.add(lines.substring(8))
//          } else {
//            val newLines: util.HashSet[String] = new util.HashSet[String]()
//            newLines.add(lines.substring(8))
//            oldHashMap.put(memberId, newLines)
//          }
//        }
//      }
//    }
//
//
//    isCorrectionReport = false
//    for(lines <- newSource.getLines() ) {
//
//      if (lines != null && lines.length > 0) {
//        if (!isCorrectionReport) isCorrectionReport = lines.startsWith("1REPORT   : RAPS408")
//
//        val recordPrefix = getSubStr(lines, 1, 8)
//
//        if (isCorrectionReport && StringUtils.isNotBlank(recordPrefix) && recordPrefix.matches("[0-9]{7}")) {
//          val memberId = getSubStr(lines, 31, 44)
//
//
//          if (newHashMap.containsKey(memberId)) {
//            val oldLines: util.HashSet[String] = newHashMap.get(memberId)
//            oldLines.add(lines.substring(8))
//          } else {
//            val newLines: util.HashSet[String] = new util.HashSet[String]()
//            newLines.add(lines.substring(8))
//            newHashMap.put(memberId, newLines)
//          }
//        }
//      }
//
//    }
//
//    val oldEntry = oldHashMap.entrySet.iterator
//    bw.write(header)
//    bw.write("\r\n")
//
//    var count = 0
//    while (oldEntry.hasNext) {
//      val entry = oldEntry.next
//      if(entry.getKey != null && newHashMap.get(entry.getKey) != null ) {
//
//        val lineSet : util.HashSet[String] = entry.getValue
//
//        val newLineSet = newHashMap.get(entry.getKey)
//
//        lineSet.forEach(line => {
//          if(!newLineSet.contains(line)) {
//            val output = "%07d".format(count)
//            bw.write(" " + output)
//            bw.write(line)
//            bw.write("\r\n")
//            count += 1
//          }
//        })
//      }
//    }
//
//    bw.write(footer)
//    bw.close()
//
//  }

  def getSubStr(record: String, start: Int, `end`: Int): String = if (record.length >= `end`) record.substring(start, `end`).trim
  else null
}
