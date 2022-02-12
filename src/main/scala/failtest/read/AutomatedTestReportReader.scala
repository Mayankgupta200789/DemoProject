//package failtest.read
//
//import java.io.File
//import java.util
//
//import scala.xml.{NodeSeq, XML}
//import sys.process._
//
//
//class AutomatedTestReportReader {
//
//  private val command = "C:\\EdifecsSetups\\em-full-image-installer-1.2-SNAPSHOT\\bin\\win\\EM\\RRM-8.12.3-20181009.031348-34\\RRM-8.12.3-SNAPSHOT\\tools\\TestTool\\test.bat"
//
//  def read(file: File) {
//
//    var doEnter = false
//
//    var count = 0
//
//    val element = XML.load(file.getPath)
//
//    val tableNodes = element \\ "table"
//
//    val failTestsMap : java.util.HashMap[String,String] = new util.HashMap[String,String]()
//
//    for(tableNode: NodeSeq <- tableNodes) {
//      val tableNodeId = tableNode \ "@id"
//
//      if(tableNodeId.text.equals("resultsTable")) {
//        val trNodes = tableNode \ "tr"
//
//        for(trNode: NodeSeq <- trNodes ) {
//
//          val trNodeClass = trNode \ "@class"
//          if(trNodeClass.text.contains("testName")) {
//
//            val tdNodes = trNode \ "td"
//
//            for(tdNode: NodeSeq <- tdNodes ) {
//
//              val tdNodeText = tdNode \ "@id"
//
//              if(tdNodeText.text.equals("pathToTests")) {
//
//                val fontNode = tdNode \ "font"
//
//                val colorText = (fontNode \ "@color").text
//
//                if(colorText.equalsIgnoreCase("red")) {
//
//                  val fontNodeText = fontNode.text
//
//                  val fontNodeCleanValue = fontNodeText.replace("\n","").replace("  ","")
//                  (command + " run " + fontNodeCleanValue).!
//
//                }
//              }
//            }
//
//          }
//        }
//
//
//      }
//    }
//
//
//
//  }
//
//}
