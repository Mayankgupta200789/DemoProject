package manifestCodesCompare

import java.io.{BufferedWriter, File, FileWriter}
import scala.collection.mutable
import scala.io.Source

class ManifestCodesComparator {


  def compare(oldFile: String,newFile: String): Unit = {

    val oldFilePath: String = getClass.getResource("../mao/manifest/" + oldFile + ".txt").getPath
    val oldInputFile = new File(oldFilePath)

    val newFilePath : String = getClass.getResource("../mao/manifest/" + newFile + ".txt").getPath
    val newInputFile = new File(newFilePath)

    val outputPath: String = getClass.getResource("../output").getPath
    val outputFile : File = new File(outputPath + "/mao/" + "diff.txt")

    if(!outputFile.exists()) outputFile.createNewFile()

    val bw : BufferedWriter = new BufferedWriter(new FileWriter(outputFile))

    val oldSource = Source.fromFile(oldInputFile)
    val newSource = Source.fromFile(newInputFile)
    var existingManifestCodes : mutable.HashSet[String] = new mutable.HashSet[String]()
    for (lines <- oldSource.getLines()) {

      if (lines != null && lines.nonEmpty) {
        existingManifestCodes.add(lines.trim)
      }

    }

    for(lines <- newSource.getLines() ) {

      if (lines != null && lines.nonEmpty) {
        if(!existingManifestCodes.contains(lines)) {
          bw.write(lines)
          bw.write("\n")
        }
      }
    }

    bw.close();




  }

}
