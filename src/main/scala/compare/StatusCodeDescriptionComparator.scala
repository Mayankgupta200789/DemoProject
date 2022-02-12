package compare

import java.io.{BufferedWriter, File, FileWriter}
import scala.io.Source

class StatusCodeDescriptionComparator {

  def compare(leftFile: String,rightFile: String): Unit = {

        val oldFilePath: String = getClass.getResource("../mao/statuscodedescription/" + leftFile + ".csv").getPath
        val oldInputFile = new File(oldFilePath)

        val newFilePath : String = getClass.getResource("../mao/statuscodedescription/" + rightFile + ".csv").getPath
        val newInputFile = new File(newFilePath)

        val outputPath: String = getClass.getResource("../mao/statuscodedescription/").getPath
        val outputFile1 : File = new File(outputPath + "/" + "RRM_MAOGenericErrorCodes-context.xml")
        val outputFile2 : File = new File(outputPath + "/" + "MAO002_ErrorCodesAndErrorMessage.xml")
        val outputFile3 : File = new File(outputPath + "/" + "StatusCodeDescriptionMAO-context.xml")

        if(!outputFile1.exists()) outputFile1.createNewFile()
        if(!outputFile2.exists()) outputFile1.createNewFile()
        if(!outputFile3.exists()) outputFile1.createNewFile()

        val bw1 : BufferedWriter = new BufferedWriter(new FileWriter(outputFile1))
        val bw2 : BufferedWriter = new BufferedWriter(new FileWriter(outputFile2))
        val bw3 : BufferedWriter = new BufferedWriter(new FileWriter(outputFile3))

        val leftSource = Source.fromFile(oldInputFile)
        val rightSource = Source.fromFile(newInputFile)

    val rightHashMap: java.util.TreeMap[String, String] = new java.util.TreeMap[String, String]()
    val statusMap: java.util.TreeMap[String, String] = new java.util.TreeMap[String, String]()

    for (rightLines <- rightSource.getLines()) {

      if(rightLines.length > 8 ) {
          val rightLinesStatus = rightLines.substring(0, 1).trim
          val rightLinesCode = rightLines.substring(4, 10).trim
          var rightLinesDescription = rightLines.substring(12).trim
         rightLinesDescription.replaceAll("&","&amp;")
         rightLinesDescription.replaceAll("&nbsp;","")
         rightLinesDescription.replaceAll("'","")

          statusMap.put(rightLinesCode,rightLinesStatus)

          if(!rightLinesStatus.equalsIgnoreCase("D")) {
            rightHashMap.put(rightLinesCode,rightLinesDescription);
          }
        }
      }



        for (lines <- leftSource.getLines()) {

          if (lines != null && lines.nonEmpty) {

            if(lines.length > 8 ) {
                    val leftLinesCode = lines.substring(0, 5)
                    val leftLinesDescription = lines.substring(8).trim

                    if(statusMap.containsKey(leftLinesCode) && !statusMap.get(leftLinesCode).equalsIgnoreCase("D")) {
                      if (rightHashMap.containsKey(leftLinesCode) && !rightHashMap.get(leftLinesCode).equalsIgnoreCase(leftLinesDescription)) {
                        rightHashMap.put(leftLinesCode, rightHashMap.get(leftLinesCode))
                      }
                    }
           }
         }
      }

    val iterator1 = rightHashMap.entrySet().iterator()
    val iterator2 = rightHashMap.entrySet().iterator()
    val iterator3 = rightHashMap.entrySet().iterator()
    while (iterator1.hasNext) {
      val entry = iterator1.next()
      bw1.write("\t\t")
      bw1.write("<entry key=\"")
      bw1.write(entry.getKey)
      bw1.write("\" value=\"")
      bw1.write("MO_" + entry.getKey)
      bw1.write("\"/>")
      bw1.write("\n")
    }

    while (iterator2.hasNext) {
      val entry = iterator2.next()
      bw2.write("\t\t")
      bw2.write("<Error id=\"")
      bw2.write("MO_" + entry.getKey)
      bw2.write("\" key=\"")
      bw2.write(entry.getKey)
      bw2.write("\" message=\"")
      bw2.write(entry.getValue)
      bw2.write("\"/>")
      bw2.write("\n")
    }

    while (iterator3.hasNext) {
      val entry = iterator3.next()
      bw3.write("\t\t")
      bw3.write("<entry key=\"")
      bw3.write(entry.getKey)
      bw3.write("\" value=\"")
      bw3.write(entry.getValue)
      bw3.write("\"/>")
      bw3.write("\n")
    }

    bw1.close()
    bw2.close()
    bw3.close()
  }

}
