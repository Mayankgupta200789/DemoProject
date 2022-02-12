//import java.io.File
//
//import scala.xml.XML
//
//class XMLParser {
//
//  def parse(): Unit = {
//
//    var files : List[File] = getListOfFiles("C:\\KPDevelopment\\engineering\\apps\\Financial\\RRM\\DemoProject\\src\\main\\resources")
//
//    var id = 0
//
//
//    for(file : File <- files ) {
//
//      val element = XML.load(file.getPath)
//
//      val etlNode = element \\ "ETL"
//
//      val source = "Source element is " + (etlNode \ "@source").text
//      val target = "Source element is " + (etlNode \ "@target").text
//      val etlid = "Source element is " + (etlNode \ "@id").text
//
//
//      println(etlid)
//      println(source)
//      println(target)
//
//      val etl = ETL(id, etlid, source, target)
//
//
//    }
//
//
//
//  }
//
//  def getListOfFiles(dir: String):List[File] = {
//    val d = new File(dir)
//    if (d.exists && d.isDirectory) {
//      d.listFiles.filter(_.isFile).toList
//    } else {
//      List[File]()
//    }
//  }
//
//}
