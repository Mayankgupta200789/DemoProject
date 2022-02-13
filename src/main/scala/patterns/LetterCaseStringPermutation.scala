package patterns

import patterns.subsets.LetterCaseStringPermutation

import java.util
import java.util.{Arrays, List}

/**
 * Time complexity : O(N * 2^N)
 * Space complexity : O(N * 2^N)
 *
 */


object LetterCaseStringPermutation {


  def main(args: Array[String]): Unit = {
    val startTime = System.currentTimeMillis
    var result = LetterCaseStringPermutation.findLetterCaseStringPermutations("abcdefghijkl")
    val endTime = System.currentTimeMillis
    System.out.println("Elapse time recursive is  " + (endTime - startTime))
  }

  def findLetterCaseStringPermutations(str: String): Unit = {

    var permutations = new util.ArrayList[String]()

    permutations.add(str)

    for (i <- 0 until str.length) {

      if (Character.isLetter(str.charAt(i))) {

        var size = permutations.size()

        for (j <- 0 until size) {

          val chars = permutations.get(j).toCharArray

          if (Character.isLowerCase(chars(i))) chars(i) = Character.toUpperCase(chars(i)) else chars(i) = Character.toLowerCase(chars(i))
          permutations.add(util.Arrays.toString(chars))
        }
      }
    }

    permutations
  }

}
