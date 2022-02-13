package patterns

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object SubSetsWithoutDuplicates {

  def main(args: Array[String]): Unit = {
    var result1 = findSubSets(Array[Int](1,5,3))
    println("Here is the list of subsets: " + result1)
    result1 = findSubSets(Array[Int](1, 5, 2, 3))
    println("Here is the list of subsets: " + result1)

  }

  def findSubSets(nums: Array[Int]) : ArrayBuffer[ArrayBuffer[Integer]] = {

    scala.util.Sorting.stableSort(nums)

    val result: ArrayBuffer[ArrayBuffer[Integer]] = mutable.ArrayBuffer[ArrayBuffer[Integer]]()

    result += mutable.ArrayBuffer[Integer]()

    var hashSet : mutable.HashSet[ArrayBuffer[Integer]]  = mutable.HashSet[ArrayBuffer[Integer]]()

    for( number <- nums) {

      val n = result.size

      for(i <- 0 until n ) {

        var set : ArrayBuffer[Integer] = new ArrayBuffer[Integer]()
        result(i).copyToBuffer(set)
        set += (number)
        if(!hashSet.contains(set)) {
          result += (set)
          hashSet += set
        }
      }

    }

    result



  }

}
