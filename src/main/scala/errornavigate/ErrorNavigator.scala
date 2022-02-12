//package errornavigate
//
//import java.io.{BufferedWriter, File, FileWriter}
//
//import scala.xml.XML
//
//
//class ErrorNavigator {
//
//  val kpName = "VA"
//
//  val ERROR_IDENTIFIER_FLAG = "<Error id"
//
//  val header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<LocatorRules xmlns=\"http://www.edifecs.com/elm/ucf/locator\">"
//
//  val footer = "</LocatorRules>"
//
//  var node = "<Node key=\"{key}\">\n        <MultistepStrategy>\n            <LocatorStep>\n                <Expression>{location}</Expression>\n            </LocatorStep>\n        </MultistepStrategy>\n    </Node>"
//
//  def copyErrorNavigate(): Unit ={
//
//    val inputPath: String = getClass.getResource("../claim/" + kpName + "/" + "277_ErrorCodesAndErrorMessage.xml").getPath
//
//    val inputFile = new File(inputPath)
//
//
//    val outputPath: String = getClass.getResource("../claim").getPath
//    val outputFile : File = new File(outputPath + "/" + kpName + "/RRM_GenericErrorCodes_ECHCF.xml")
//    if(!outputFile.exists()) outputFile.createNewFile()
//
//    val rootInputElement = XML.load(inputPath)
//
//    val childErrorElements = rootInputElement \\ "Error"
//
//    val bw = new BufferedWriter(new FileWriter(outputFile,true))
//
//    bw.write(header)
//
//    var temp = ""
//    for(childErrorElement <- childErrorElements ) {
//
//      val keyElement = childErrorElement \ "@id"
//      val locationElement = childErrorElement \ "@location"
//
//      temp = node.replace("{key}",keyElement.toString())
//      temp = temp.replace("{location}",locationElement.toString())
//      bw.write(temp)
//    }
//
//    bw.write(footer)
//    bw.close()
//
//
//  }
//}
