package compare

import org.scalatest.FunSuite

class StatusCodeDescriptionComparatorTest extends FunSuite {

    test("testCompare") {

    val comparator = new StatusCodeDescriptionComparator
    comparator.compare("leftFile","rightFile")

  }

}
