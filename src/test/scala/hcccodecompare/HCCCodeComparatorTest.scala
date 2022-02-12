package hcccodecompare

import org.scalatest.FunSuite

class HCCCodeComparatorTest extends FunSuite {

  test("testCompare") {

    val comparator = new HCCCodeComparator
    comparator.compare("oldhccmao","newhccmao")
  }

}
