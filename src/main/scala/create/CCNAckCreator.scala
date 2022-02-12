package create

import java.io.{BufferedWriter, File, FileWriter}

import scala.io.Source

class CCNAckCreator {


  var header = "0^CCN-W-010 ^20180402^Claims Detail                                     ^0137716^"
  var footer = "9^CCN-W-010 ^00641612^99^00158627^"


  def create(kpName: String, ackType: String): Unit = {

    val path: String = getClass.getResource("../claim/" + kpName + "/" + ackType + ".dat").getPath
    val inputFile = new File(path)

    val outputPath: String = getClass.getResource("../output").getPath
    val outputFile : File = new File(outputPath + "/" + kpName + "/" + ackType + ".dat")

    val bw : BufferedWriter = new BufferedWriter(new FileWriter(outputFile))

    val listOfEncounters = 3
    bw.write(header)
    bw.write("\n")

    for(index  <- 0 until listOfEncounters) {

      val source = Source.fromFile(inputFile)
      for (lines <- source.getLines()){
        bw.write(lines)
      }
    }
    bw.write("\n")

    bw.write(footer)
    bw.close()
  }
}
