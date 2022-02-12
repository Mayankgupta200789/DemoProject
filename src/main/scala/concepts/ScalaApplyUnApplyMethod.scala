package concepts


class ScalaApplyUnApplyMethod  (val input: String, val number: Int) {

    println(input)
   println(number)
}


object ScalaApplyUnApplyMethod {


  def main(args: Array[String]): Unit = {

      ScalaApplyUnApplyMethod("String",2)

    val tuple = ("input", 2)
    val tuple2 = ("input", "2")

    tuple match {
      case (input,number) => {
        println(" input match " + input)
        println("number match " + number)
      }
      case tuple2 =>  {
        println("Second pattern")
      }
    }

  }

  /**
   * Apply method basically lets you initialize the class
   * without using keyword new
   * */
  def apply(input: String, number: Int): Unit = {
    new ScalaApplyUnApplyMethod(input,number)
  }

  /**
   * Its basically used in pattern matching
   * whenever you use any tuple for pattern matching
   * it will indirectly call unapply method
   *
   * @param result
   * @return
   */
  def unapply(result: ScalaApplyUnApplyMethod) : Option[(String,Int)] =  {
    Some((result.input,result.number))
  }

}
