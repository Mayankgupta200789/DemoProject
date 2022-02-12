package specialitycodescompare

import java.io.{BufferedWriter, File, FileWriter}
import scala.collection.mutable
import scala.io.Source

class SpecialityCodeCompare {


  def compare(oldFile: String,newFile: String): Unit = {

    val oldFilePath: String = getClass.getResource("../mao/speciality/" + oldFile + ".txt").getPath

    val oldInputFile = new File(oldFilePath)
//    val oldInputFileHCC = new File(oldFilePathHCC)

    val newFilePath : String = getClass.getResource("../mao/speciality/" + newFile + ".txt").getPath
    val newInputFile = new File(newFilePath)

    val outputPath: String = getClass.getResource("../output").getPath
    val outputFile : File = new File(outputPath + "/mao/" + "diffSpeciality.txt")

    if(!outputFile.exists()) outputFile.createNewFile()

    val bw : BufferedWriter = new BufferedWriter(new FileWriter(outputFile))
    val oldSource = Source.fromFile(oldInputFile)
//    val oldSourceHCC = Source.fromFile(oldInputFileHCC)
    val newSource = Source.fromFile(newInputFile)
    val newCodes: mutable.HashSet[String] = new mutable.HashSet[String]()
    val newCodeMap: mutable.HashMap[String,String] = new mutable.HashMap[String,String]()
    val newHCCCodeMap: mutable.TreeMap[String,String] = new mutable.TreeMap[String,String]()
    val existingHCC: mutable.HashSet[String] = new mutable.HashSet[String]()
    val hccAdded: mutable.HashSet[String] = new mutable.HashSet[String]()


    for (lines <- newSource.getLines()) {

      val codes = lines.split(",")
      newCodes.add(codes(0))
      newCodeMap.put(codes(0),codes(1))
    }

    for(lines <- oldSource.getLines()){
      val oldCodes = lines.split(",")
      if(newCodes.contains(oldCodes(0)) && oldCodes(1).equals("1")) {
        bw.write(oldCodes(0))
        bw.write("\n")
      } else if (!newCodes.contains(oldCodes(0))
        && oldCodes(1).equals("0")) {
        bw.write(oldCodes(0))
        bw.write("\n")
      }
    }

    bw.close()

  }

}
