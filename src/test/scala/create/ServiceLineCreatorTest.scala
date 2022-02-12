package create

import org.scalatest.FunSuite

class ServiceLineCreatorTest extends FunSuite {


  test("testCreate") {

    val creator = new ServiceLineCreator("LA")

    creator.create("ProfClaim",100)

  }

}
