package create

import org.scalatest.FunSuite

class MAO002AckPartialCreatorTest extends FunSuite {

  test("testCreate") {

    val creator = new MAO002AckPartialCreator

    var i = 4;
    while( i < 7 ) {
      creator.create("MAO", "MAO_Inst_01_ack_" + i)
      i = i+1
    }


  }

}
