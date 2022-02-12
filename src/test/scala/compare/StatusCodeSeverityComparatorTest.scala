package compare

import org.scalatest.FunSuite

class StatusCodeSeverityComparatorTest extends FunSuite {

  test("testCompare") {

    val comparator = new StatusCodeSeverityComparator
    comparator.compare("leftFile","rightFile")

  }

}
