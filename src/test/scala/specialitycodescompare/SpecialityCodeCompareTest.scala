package specialitycodescompare

import org.scalatest.FunSuite

class SpecialityCodeCompareTest extends FunSuite {

  test("testCompare") {
    val specialityCodesCompare = new SpecialityCodeCompare
    specialityCodesCompare.compare("olderspeciality","newspeciality")
  }

}
