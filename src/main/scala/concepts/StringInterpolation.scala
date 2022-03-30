package concepts

/**
 *
 * String interpolation in the Scala programming language
 * refers to the process of replacing certain variables or expressions
 * within a string with some other suitable value according to the context.

 */
*/
object StringInterpolation {

  def main(args: Array[String]): Unit = {

    val name = "mark"
    val age = "18"

    println(name + " is " + age + " years old ")
    println(s"$name is $age years old")
//    println(f"$name%s is $age%f years old")
  }

}
