package patterns

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object MainClass {

  def main(args: Array[String]): Unit = {
    var result1 = findSubSets(Array[Int](1,5,3))
    println("Here is the list of subsets: " + result1)
    result1 = findSubSets(Array[Int](1, 5, 2, 3))
    println("Here is the list of subsets: " + result1)

  }

  def findSubSets(nums: Array[Int]) : ArrayBuffer[ArrayBuffer[Integer]] = {

    val result: ArrayBuffer[ArrayBuffer[Integer]] = mutable.ArrayBuffer[ArrayBuffer[Integer]]()

    result += mutable.ArrayBuffer[Integer]()

    for( number <- nums) {

      val n = result.size

      for(i <- 0 until n ) {

        var set : ArrayBuffer[Integer] = new ArrayBuffer[Integer]()
        result(i).copyToBuffer(set)
        set += (number)
        result += (set)
      }

    }

    result



  }

}
