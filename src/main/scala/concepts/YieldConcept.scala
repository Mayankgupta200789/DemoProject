package concepts

object YieldConcept {


  def main(args: Array[String]): Unit = {

    var value = for{i <- 0 until 10 } yield i

    for(i <- value.indices) {
      println(i)
    }
  }

  def checkEither(input: Int) : Either[String,Int] = {

    if (input < 0) Left("Input is negative zero")
    else Right(input)

  }

  def checkOption(input: Int) : Option[Int] = {

    var a : Option[Int] = Some(1)
    var b : Option[String] = None
    a
  }
}
