import org.scalatest.{BeforeAndAfterEach, FunSuite}

class XMLParserTest extends FunSuite with BeforeAndAfterEach {


  var xmlParser : XMLParser = _

  override def beforeEach() {
      xmlParser = new XMLParser()
  }

  override def afterEach() {

  }

  test("testParse") {
      xmlParser.parse()
  }

}
