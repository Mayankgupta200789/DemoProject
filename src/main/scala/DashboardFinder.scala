import java.io.File

import scala.collection.mutable
import scala.io.Source
import scala.util.control.Breaks


class DashboardFinder(resourceName: String) {

//  var set : mutable.HashSet[String] = new mutable.HashSet[String]()
//
//  def find(files: Array[File],tableName: String) {
//
//     val loop = new Breaks
//    loop.breakable {
//      for (file: File <- files) {
//        if (file.isDirectory) {
//          find(file.listFiles(), tableName)
//        } else if (file.getName.equalsIgnoreCase("queries.xml")) {
//          for (lines <- Source.fromFile(file).getLines()) {
//            if (lines.contains(tableName) && !set.contains(file.getParent.split(File.separator + File.separator).last)) {
//              val dashboardName = file.getParent.split(File.separator + File.separator).last
//              println(dashboardName)
//              set.add(dashboardName)
//            }
//          }
//        }
//      }
//    }

//  }
}
