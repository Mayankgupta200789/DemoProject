package manifestCodesCompare

import org.scalatest.FunSuite

class ManifestCodesComparatorTest extends FunSuite {


  test("testManifest") {

    val comparator = new ManifestCodesComparator
    comparator.compare("oldCodes","newCodes")


  }

}
