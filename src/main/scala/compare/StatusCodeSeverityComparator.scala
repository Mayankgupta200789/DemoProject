package compare

import java.io.{BufferedWriter, File, FileWriter}
import scala.io.Source

class StatusCodeSeverityComparator {

  def compare(leftFile: String,rightFile: String): Unit = {

        val oldFilePath: String = getClass.getResource("../mao/statuscodeseverity/" + leftFile + ".csv").getPath
        val oldInputFile = new File(oldFilePath)

        val newFilePath : String = getClass.getResource("../mao/statuscodeseverity/" + rightFile + ".csv").getPath
        val newInputFile = new File(newFilePath)

        val outputPath: String = getClass.getResource("../mao/statuscodeseverity/").getPath
        val outputFile : File = new File(outputPath + "/" + "diff.xml")

        if(!outputFile.exists()) outputFile.createNewFile()

        val bw : BufferedWriter = new BufferedWriter(new FileWriter(outputFile))

        val leftSource = Source.fromFile(oldInputFile)
        val rightSource = Source.fromFile(newInputFile)

    val rightHashMap: java.util.TreeMap[String, String] = new java.util.TreeMap[String, String]()

    val duplicate: java.util.HashSet[String] = new java.util.HashSet[String]();

    for (rightLines <- rightSource.getLines()) {

      if(rightLines.length >= 7  && !rightLines.substring(6).trim.equals("D")) {
          val rightLinesCode = rightLines.substring(0, 6).trim
          val rightLineStatus = rightLines.substring(6).trim
          if(rightHashMap.containsKey(rightLinesCode) && !rightLineStatus.equalsIgnoreCase(rightHashMap.get(rightLinesCode))) {
            duplicate.add(rightLinesCode)
          }else {
            rightHashMap.put(rightLinesCode,rightLineStatus);
          }
        }
      }



        for (lines <- leftSource.getLines()) {

          if (lines != null && lines.nonEmpty) {

            if(lines.length >= 7 ) {
                val leftLinesCode = lines.substring(0,6).trim
                  val leftLineStatus = lines.substring(6).trim

                  if(!leftLineStatus.equals("D")) {
                    if(duplicate.contains(leftLinesCode)) {
                      rightHashMap.put(leftLinesCode, "R")
                    } else if (rightHashMap.containsKey(leftLinesCode) && !rightHashMap.get(leftLinesCode).equalsIgnoreCase(leftLineStatus)) {
                      rightHashMap.put(leftLinesCode, rightHashMap.get(leftLinesCode))
                    }
                  }
              }
            }
          }

    val iterator = rightHashMap.entrySet().iterator()
    while (iterator.hasNext) {
      val entry = iterator.next()
      bw.write("\t\t")
      bw.write("<entry key=\"")
      bw.write(entry.getKey)
      bw.write("\" value=\"")
      bw.write(entry.getValue)
      bw.write("\"/>")
      bw.write("\n")
    }

    bw.close()


  }

}
