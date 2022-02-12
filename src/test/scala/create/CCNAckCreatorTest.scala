package create

import org.scalatest.FunSuite

class CCNAckCreatorTest extends FunSuite {

  test("testCreate") {
      val creator = new CCNAckCreator

    creator.create("LA","CCN")
  }

}
