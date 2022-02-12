package create

import java.io.{BufferedWriter, File, FileWriter}

import scala.io.Source

class MAO002AckPartialCreator {

  def create(kpName: String, ackType: String): Unit = {

    // WHEN CREATING ACK FILES PLEASE OPEN THIS FILE IN NOTEPAD++ AND CHECK FOR
    // \r\n characters. Visual studio code cannot catch it.

    val path: String = getClass.getResource("../claim/" + kpName + "/" + ackType + ".dat").getPath
    val inputFile = new File(path)

    val outputPath: String = getClass.getResource("../output").getPath
    val outputFile : File = new File(outputPath + "/" + kpName + "/" + ackType + ".dat")

    if(!outputFile.exists()) outputFile.createNewFile()

    val bw : BufferedWriter = new BufferedWriter(new FileWriter(outputFile))

    val source = Source.fromFile(inputFile)
    var count : Long = 0;
    for (lines <- source.getLines()){
      // For Rejected Scenario
      if(count >= 0 && count < 2500 ) {
        bw.write(lines)
        bw.write("\r\n")
      }
      //For Partial Scenario
      else if (count >= 2500 && count < 5000) {
        val acceptedLine = lines.replace(",000,Rejected,00000,Error Description Error Description  Err,Filler", ",000,Accepted,     ,                                        ,Filler")
        bw.write(acceptedLine)
        bw.write("\r\n")
        var rejectedLine = lines.replace(",000,Rejected",",001,Rejected")
        bw.write(rejectedLine)
        bw.write("\r\n")
      }
      // For Accepted Scenario
      else {
        val acceptedLine = lines.replace(",000,Rejected,00000,Error Description Error Description  Err,Filler", ",000,Accepted,     ,                                        ,Filler")
        bw.write(acceptedLine)
        bw.write("\r\n")
      }
      count = count + 1;
    }
    println(count)
    bw.close()
  }

}
