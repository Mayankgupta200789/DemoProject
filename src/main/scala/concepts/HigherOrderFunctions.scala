package concepts

object HigherOrderFunctions {

  def first(a: String, b: String): String = {
    a + " and " + b
  }

  def second(first: (String,String) => String, c: String, d: String): String = {
    first(c,d)
  }

  def main(args: Array[String]): Unit = {
    println(second(first:(String,String) => String ,"third","fourth"))
  }


}
