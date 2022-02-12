package create

import org.scalatest.FunSuite

class BRRAckCreatorTest extends FunSuite {

  test("testCreate") {
    val creator = new BRRAckCreator

    creator.create("WV","BRR")
  }

}
