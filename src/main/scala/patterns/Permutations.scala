package patterns

import patterns.subsets.Permutations

import java.util.List
import scala.collection.mutable.ArrayBuffer

object Permutations {

  def main(args: Array[String]): Unit = {
    val result = Permutations.findPermutations(Array[Integer](1, 3, 5))
    System.out.print("Here are all the permutations: " + result)
  }


  import java.util

 def findPermutations(nums: Array[Integer]) : ArrayBuffer[ArrayBuffer[Integer]] = {

   var result = new ArrayBuffer[ArrayBuffer[Integer]]

   var choices = new ArrayBuffer[Integer]()

   for(i <- nums.indices ) {

     choices += nums(i)
   }

   doFindPermute(result,choices,new ArrayBuffer[Integer])
   result
  }

  def doFindPermute(result : ArrayBuffer[ArrayBuffer[Integer]],
                        choices: ArrayBuffer[Integer],prefix: ArrayBuffer[Integer] ) : Unit ={


    if(choices.isEmpty ){
      val temp = new ArrayBuffer[Integer]()
      prefix.copyToBuffer(temp)
      result += temp
    } else {

      for(i <- choices.indices) {

        prefix += choices(i)
        var elem = choices.remove(i)
        doFindPermute(result,choices,prefix)
        choices.insert(i,elem)
        prefix.remove(prefix.size - 1)

      }
    }
  }

}
