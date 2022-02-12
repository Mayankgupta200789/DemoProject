package concepts

import scala.collection.mutable
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

object MutableDataStructure {

  def main(args: Array[String]): Unit = {

    var newMap : mutable.HashMap[String,String] = mutable.HashMap()
    var newList = new mutable.ArrayBuffer[String]()
    var newSet = new mutable.HashSet[String]()


    newList += "hellp"
    newSet += "asa"

    newMap.foreach {
      entry => println(entry._1)
    }

    newSet.foreach {
      key => println(key)
    }


    for(input <- newList ) {
      println(input)
    }

    for(entry <- newMap) {
      println(entry._1)
    }

    newMap += ("key" -> "value")

    var hashMap : mutable.HashMap[String, String]  = mutable.HashMap()
    var arrayBuffer : mutable.ArrayBuffer[String]  = mutable.ArrayBuffer()
    var hashSet : mutable.HashSet[String]  = mutable.HashSet()

    hashMap += ("key" -> "value")
    arrayBuffer += ("list")
    hashMap.foreach(entry => {

      println(entry._1)
      hashSet += entry._1
      hashSet += entry._2
      println(entry._2)
    })

    arrayBuffer.foreach(input => println(input))
    hashSet.foreach(input => println(input))

  }

}
