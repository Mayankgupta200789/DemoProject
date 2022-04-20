package concepts

object MainClass {

  def main(args: Array[String]): Unit = {
    println("Hello scala ")

    val days = List("Sunday",
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday")

    val year = List("2021","2022","2023")

    days.foreach(day => println("The day is " + day))

    val outputs = days.map(day => day + ",")

    println("outputs " + outputs)

    val flatMappedOutput = days.flatMap(day => List(day, day + "2"))
    val normalMappedOutput = days.map(day => List(day, day + "2"))

    val monads = days.map(day => outputs.flatMap(output => day + output))

//    println(flatMappedOutput)
//    println(normalMappedOutput)
//    println(monads)

    val list = List(1,2,3)

    def f(x:Int ) = List(x-1,x,x+1)

    val result = list.flatMap(y => f(y))
    val result2 = list.map(y => f(y))

    var result5 = list.map(y => List(y*2))
    var result6 = list.flatMap(y => List(y*2))

    println(result)
    println(result2)
    print("map result " + result5)
    println()
    print("flat map  result " + result6)
    println()

    //Scala reduce function

    println(list.reduce((x,y) => x max y ))
    println(list.reduce((x,y) => x min y ))

    val tuples = list.map(x => (x, 1))
    println(tuples)

    val result3 = tuples.reduce((a, b) => (a._1 + b._1,a._2 + b._2))

    println(result3)

    println(list.filter(x => x < 3))
    println(list.filter(_ < 4))


    //
    val m1 = Map("geeks" -> 4 , "for" -> 3 )
    println(m1.filter(x => (x._1 == "geeks" || x._1 == "for")))


    m1.foreach(x => (x._1))

    // for loops in scala
    for(i <- 0 to 10 ) {
      println(i)
    }

    for(i <- 0 to 10 ; w <- 1 until 20 ) {
      println(i)
      println(w)
    }

    for( l <- list ) {
      println("the value in list is " + l)
    }


    for(l <- list
        if( l <3 )) {
      println(l)
    }

    val result4 = for{l <- list
        if( l < 3 )} yield l




    // Two dimensional arrays
    var mymultiArr  = Array.ofDim[Int](2,3)

    // iterating through two dimensional arrays


    for (i <- mymultiArr.indices; j <-  mymultiArr(0).indices) {

    }




  }

}
