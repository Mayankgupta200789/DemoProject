package hcccodecompare

import java.io.{BufferedWriter, File, FileWriter}
import scala.collection.mutable
import scala.io.Source

class HCCCodeComparator {


  def compare(oldFile: String,newFile: String): Unit = {

    val oldFilePath: String = getClass.getResource("../mao/hcc/" + oldFile + ".csv").getPath
//    val oldFilePathHCC: String = getClass.getResource("../mao/hcc/" + "hccweight.csv").getPath

    val oldInputFile = new File(oldFilePath)
//    val oldInputFileHCC = new File(oldFilePathHCC)

    val newFilePath : String = getClass.getResource("../mao/hcc/" + newFile + ".csv").getPath
    val newInputFile = new File(newFilePath)

    val outputPath: String = getClass.getResource("../output").getPath
    val outputFile : File = new File(outputPath + "/mao/" + "diffHcc.txt")
    val outputHCCFile: File = new File(outputPath + "/mao/" + "missingHCC.txt")
    val outputFileMAO : File = new File(outputPath + "/mao/" + "2022.icd.cc.map-context.xml")
    val outputFileRA : File = new File(outputPath + "/mao/" + "2022.icd.cc.map")

    if(!outputFile.exists()) outputFile.createNewFile()
    if(!outputHCCFile.exists()) outputHCCFile.createNewFile()
    if(!outputFileMAO.exists()) outputFileMAO.createNewFile()
    if(!outputFileRA.exists()) outputFileRA.createNewFile()

    val bw : BufferedWriter = new BufferedWriter(new FileWriter(outputFile))
    val bwMAO : BufferedWriter = new BufferedWriter(new FileWriter(outputFileMAO))
    val bwRA : BufferedWriter = new BufferedWriter(new FileWriter(outputFileRA))
    val bwHCC : BufferedWriter = new BufferedWriter(new FileWriter(outputHCCFile))

    val oldSource = Source.fromFile(oldInputFile)
//    val oldSourceHCC = Source.fromFile(oldInputFileHCC)
    val newSource = Source.fromFile(newInputFile)
    val existingHCCCodes: mutable.HashSet[String] = new mutable.HashSet[String]()
    val existingHCCCodesMap: mutable.HashMap[String,String] = new mutable.HashMap[String,String]()
    val newHCCCodeMap: mutable.TreeMap[String,String] = new mutable.TreeMap[String,String]()
    val existingHCC: mutable.HashSet[String] = new mutable.HashSet[String]()
    val hccAdded: mutable.HashSet[String] = new mutable.HashSet[String]()
    for (lines <- oldSource.getLines()) {

      if (lines != null
        && lines.nonEmpty
        ) {
        existingHCCCodes.add(lines.trim)
        val inputs = lines.split(",")
        if(inputs.length == 1 ) {
          existingHCCCodesMap.put(inputs(0), "")
        }else {
          existingHCCCodesMap.put(inputs(0), inputs(1))
          newHCCCodeMap.put(inputs(0),inputs(1))
        }
      }
    }
//    for (lines <- oldSourceHCC.getLines()) {
//
//      if (lines != null
//        && lines.nonEmpty
//        && lines.split(",") != null
//        && lines.split(",").length == 2
//      ) {
//        existingHCC.add(lines.split(",")(0).trim)
//      }
//    }

    if(oldFile.contains("mao")) {
      bwMAO.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<beans xmlns=\"http://www.springframework.org/schema/beans\"\n\t   xmlns:util=\"http://www.springframework.org/schema/util\"\n\t   xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n\t   xsi:schemaLocation=\"http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util-2.5.xsd\">\n\t<util:map id=\"icdCCMap2022\" map-class=\"java.util.HashMap\">\n");
    }

    for(lines <- newSource.getLines() ) {

      if (lines != null
        && lines.nonEmpty
        && lines.split(",") != null
        && lines.split(",").length == 2
        ) {
        if(!existingHCCCodes.contains(lines)) {
          if(oldFile.contains("mao") || oldFile.contains("raps")) {
             newHCCCodeMap.put(lines.split(",")(0),lines.split(",")(1))
//            bwMAO.write("\t\t<entry key=")
//            bwMAO.write("\"" + lines.split(",")(0) +"\"")
//            bwMAO.write("  ")
//            bwMAO.write("value=\"" + lines.split(",")(1) + "\"" + "/>")
//            bwMAO.write("\n")
          }
        } else {
          if(!lines.split(",")(1).isBlank) {
            newHCCCodeMap.put(lines.split(",")(0),lines.split(",")(1))
//            bwMAO.write("\t\t<entry key=")
//            bwMAO.write("\"" + lines.split(",")(0) +"\"")
//            bwMAO.write("  ")
//            bwMAO.write("value=\"" + lines.split(",")(1) + "\"" + "/>")
//            bwMAO.write("\n")
          } else if(existingHCCCodesMap.contains(lines.split(",")(0)) && !existingHCCCodesMap.get(lines.split(",")(0)).toString.isBlank ){
              newHCCCodeMap.put(lines.split(",")(0),existingHCCCodesMap.get(lines.split(",")(0)).toString)
//            bwMAO.write("\t\t<entry key=")
//            bwMAO.write("\"" + lines.split(",")(0) +"\"")
//            bwMAO.write("  ")
//            bwMAO.write("value=\"" + existingHCCCodesMap.get(lines.split(",")(0)) + "\"" + "/>")
//            bwMAO.write("\n")
          }
        }


//        if(!existingHCC.contains(lines.split(",")(1).trim)
//          && !hccAdded.contains(lines.split(",")(1).trim)) {
//          bwHCC.write("Missing HCC " + lines.split(",")(1).trim)
//          bwHCC.write("\n")
//          hccAdded.add(lines.split(",")(1))
//        }
      }
    }

    for((key,value) <- newHCCCodeMap) {
      bwMAO.write("\t\t<entry key=")
      bwMAO.write("\"" + key +"\"")
      bwMAO.write("  ")
      bwMAO.write("value=\"" + value + "\"" + "/>")
      bwMAO.write("\n")
      bwRA.write(key)
      bwRA.write("\t")
      bwRA.write(value)
      bwRA.write("\n")
    }

    if(oldFile.contains("mao")) {
      bwMAO.write("\t</util:map>\n</beans>")
    }

    bw.close()
    bwMAO.close()
    bwHCC.close()
    bwRA.close()
  }

}
