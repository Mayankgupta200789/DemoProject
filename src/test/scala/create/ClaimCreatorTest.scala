package create

import org.scalatest.FunSuite

class ClaimCreatorTest extends FunSuite {

  test("testCreate") {

    val creator = new ClaimCreator("WV")

    creator.create(5000,1,"ProfClaim")

  }

}
