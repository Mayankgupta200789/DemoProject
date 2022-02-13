package concepts
import scala.collection.JavaConverters._
object JavaScalaConverter extends App{


    var list = List(1,2,3)

    var javaList = list.asJava

    var scalaList = javaList.asScala

    println(scalaList)
    println(javaList)
    println(list)


}
