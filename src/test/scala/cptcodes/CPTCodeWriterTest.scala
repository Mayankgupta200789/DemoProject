package cptcodes

import org.scalatest.FunSuite

class CPTCodeWriterTest extends FunSuite {

  test("testWrite") {

    val writer = new CPTCodeWriter
    writer.writeCPTCodes()

  }
}
