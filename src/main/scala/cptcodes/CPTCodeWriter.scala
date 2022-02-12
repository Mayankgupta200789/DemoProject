package cptcodes

import java.io.{BufferedWriter, File, FileWriter}
import java.util
import scala.io.Source

class CPTCodeWriter {

  val header = "<?xml version='1.0' encoding='UTF-8'?>\r\n" + "<dataset>\r\n"
  val footer = "</dataset>"

  def writeCPTCodes(): Unit = {

    val newFilePath: String = getClass.getResource("../mao/CY2021Q2_CPTHCPCS_CMS_2021.04.26_finalforposting.csv").getPath
    val newInputFile = new File(newFilePath)

    val oldCPTFilePath: String = getClass.getResource("../mao/cptcodesets-metdata.xml").getPath
    val oldCPTInputFile = new File(oldCPTFilePath)

    val outputPath: String = getClass.getResource("../mao").getPath
    val outputFile: File = new File(outputPath + "/newcptcodesets-metdata.xml")

    if (!outputFile.exists()) outputFile.createNewFile()

    val bw: BufferedWriter = new BufferedWriter(new FileWriter(outputFile))

    val newSource = Source.fromFile(newInputFile)
    val oldCPTSource = Source.fromFile(oldCPTInputFile)

    var i : Double = 0
    var codesid : Double = 6929000
    val lastmoddt = "2021-04-07T09:34:12.743"
    val cptCodeMap : java.util.HashMap[String,String] = new util.HashMap[String,String]()
    val existingCPTCodesMap : java.util.LinkedHashMap[String,String] = new util.LinkedHashMap[String,String]()
    val newCPTCodesMap : java.util.LinkedHashMap[String,String] = new util.LinkedHashMap[String,String]()
    var cptCodeHashSet = new util.HashSet[String]()
    codesid = 1000

    for (lines <- newSource.getLines()) {
      if (lines != null && lines.nonEmpty) {
          val outputLines = lines.replace("\"", "")
          val codes = outputLines.split(",")
         cptCodeMap.put(codes(0),codes(1))
          cptCodeHashSet.add(codes(0))
          newCPTCodesMap.put(codes(0),codes(1))
      }
    }

    i = 0
    bw.write(header)

    codesid = 1000

    for (lines <- oldCPTSource.getLines()) {
      if (lines != null && lines.nonEmpty) {
        i += 1
        if (i > 2 && i < 6931) {

          val existingCodes = lines.split(" ")
//          System.out.println("the value of existingCodes " + existingCodes(2).substring(6,existingCodes(2).length - 1))

          if(!cptCodeMap.containsKey(existingCodes(2).substring(6,existingCodes(2).length - 1).trim)
//          && !lines.substring(lines.indexOf("description=") + 13, lines.indexOf("effectiveranges") - 2).toString.trim.equalsIgnoreCase(cptCodeMap.get(existingCodes(2).substring(6,existingCodes(2).length - 1)).toString.trim)
          ) {

//            bw.write(existingCodes(0) + " " + existingCodes(1) + " " + existingCodes(2) + " " +
//              "name=\"" + cptCodeMap.get(existingCodes(2).substring(6,existingCodes(2).length - 1)) + "\" "
//              +  "description=\"" + cptCodeMap.get(existingCodes(2).substring(6,existingCodes(2).length - 1)) + "\" "
//              +  lines.substring(lines.indexOf("effectiveranges"))
//             + "/>\r\n")
            existingCPTCodesMap.put(existingCodes(2).substring(6,existingCodes(2).length - 1),lines.substring(lines.indexOf("description=") + 13, lines.indexOf("effectiveranges") - 2))

          } else {
            existingCPTCodesMap.put(existingCodes(2).substring(6,existingCodes(2).length - 1),lines.substring(lines.indexOf("description=") + 13, lines.indexOf("effectiveranges") - 2))
//            bw.write(lines)
//            bw.write("\r\n")
          }
          cptCodeHashSet.add(existingCodes(2).substring(6,existingCodes(2).length - 1).trim)
        }
      }
    }
    val setIterator = cptCodeHashSet.iterator()
    codesid = 1000

    while(setIterator.hasNext) {
      val entry :String = setIterator.next

      if(!existingCPTCodesMap.containsKey(entry)) {
        System.out.println("the value of missing entry is " + entry)
        bw.write("\t<csClmProcCodeFilter codesid=\"" + codesid + "\" code=\"" + entry.replace("\"","")
                  + "\" name=\"" + cptCodeMap.get(entry) + "\" description=\"" + cptCodeMap.get(entry)
                  + "\" effectiveranges=\"" + "\" lastmoddt=\"" + lastmoddt + "\"" + "/>")

      }

//
//      if(existingCPTCodesMap.containsKey(entry)) {
//        bw.write("\t<csClmProcCodeFilter codesid=\"" + codesid + "\" code=\"" + entry.replace("\"","")
//          + "\" name=\"" + cptCodeMap.get(entry) + "\" description=\"" + cptCodeMap.get(entry)
//          + "\" effectiveranges=\"" + "\" lastmoddt=\"" + lastmoddt + "\"" + "/>")
//      } else if(newCPTCodesMap.containsKey(entry)) {
//
//        bw.write("\t<csClmProcCodeFilter codesid=\"" + codesid + "\" code=\"" + entry.replace("\"","")
//          + "\" name=\"" + newCPTCodesMap.get(entry) + "\" description=\"" + newCPTCodesMap.get(entry)
//          + "\" effectiveranges=\"" + "\" lastmoddt=\"" + lastmoddt + "\"" + "/>")
//
//      } else {
//        System.out.println("Nothing matches")
//      }
      bw.write("\r\n")
      codesid += 1000

    }
    bw.write(footer)
    bw.close()
  }



}
