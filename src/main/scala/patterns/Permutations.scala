package patterns

import patterns.subsets.Permutations

import java.util.List
import scala.collection.mutable.Queue
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.LinkedList

import java.util

object Permutations {

  def main(args: Array[String]): Unit = {
    val startTime = System.currentTimeMillis
    val result = Permutations.findPermutations(Array[Integer](0, 1, 2, 3, 4, 5, 6, 7, 8, 9))
    val endTime = System.currentTimeMillis
    System.out.println("Elapse time recursive is  " + (endTime - startTime))
    val startTime2 = System.currentTimeMillis
    val result2 = Permutations.permuteBFS(Array[Integer](0, 1, 2, 3, 4, 5, 6, 7, 8, 9))
    val endTime2 = System.currentTimeMillis
    System.out.println("Elapse time bfs approach is  " + (endTime2 - startTime2))
  }



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


  def permuteBFS(nums: Array[Integer]) : ArrayBuffer[ArrayBuffer[Integer]] = {


    val subsets = new ArrayBuffer[ArrayBuffer[Integer]]()

    val permutations: Queue[ArrayBuffer[Integer]] = new Queue[ArrayBuffer[Integer]]()

    permutations += (new ArrayBuffer[Integer]())

    for(number <- nums){

      val size = permutations.size

      for(i <- 0 until size ) {

        val oldPermutations = permutations.dequeue()

        for(j <- 0 to oldPermutations.size ) {

          val newPermutations = new ArrayBuffer[Integer]()
          oldPermutations.copyToBuffer(newPermutations)

          newPermutations.insert(j,number)

          if(newPermutations.size == nums.length ) subsets += newPermutations
          else permutations += newPermutations
        }
      }
    }
    subsets
  }


  def doPermuteBFS(nums: Array[Integer]) : util.ArrayList[util.ArrayList[Integer]] = {


    val subsets = new util.ArrayList[util.ArrayList[Integer]]()

    val permutations: util.LinkedList[util.ArrayList[Integer]] = new util.LinkedList[util.ArrayList[Integer]]()

    permutations.add(new util.ArrayList[Integer]())

    for(number <- nums){

      val size = permutations.size

      for(i <- 0 until size ) {

        val oldPermutations = permutations.poll()

        for(j <- 0 to oldPermutations.size ) {

          val newPermutations = new util.ArrayList[Integer](oldPermutations)

          newPermutations.add(j,number)

          if(newPermutations.size == nums.length ) subsets.add( newPermutations)
          else permutations.add(newPermutations)
        }
      }
    }
    subsets
  }

}
