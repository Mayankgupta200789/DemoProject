//package amount
//
//import org.apache.poi.xssf.usermodel.XSSFWorkbook
//
//import java.io.FileInputStream
//import java.util
//import java.util.Date
//
//
//class ExcelAmountComparator() {
//
//  val firstInput = "Book1.xlsx"
//  val secondInput = "Book2.xlsx"
//
//  def compare(): Unit = {
//
//    val workbook1 = new XSSFWorkbook(new FileInputStream(getClass.getResource(firstInput).getPath))
//    val workbook2 = new XSSFWorkbook(new FileInputStream(getClass.getResource(secondInput).getPath))
//
//    val sheet1 = workbook1.getSheet("credit")
//    val sheet2 = workbook2.getSheet("credit")
//
//    val len = sheet1.getLastRowNum;
//    var i = 0
//    val dateToAmountMap1 : java.util.HashMap[Date,Double] = new util.HashMap[Date,Double]()
//    val dateToAmountMap2 : java.util.HashMap[Date,Double] = new util.HashMap[Date,Double]()
//
//
//
//    while(i <= len) {
//
//      val row1 = sheet1.getRow(i)
//
//      if (row1 != null
//        && row1.getCell(0) != null
//        && row1.getCell(0).getDateCellValue != null
//        && row1.getCell(2) != null
//        && row1.getCell(2) != null
//      ) {
//        val cell = row1.getCell(0)
//        val amountCell = row1.getCell(2)
//        //        try {
//        if (!dateToAmountMap1.containsKey(cell.getDateCellValue)) {
//          dateToAmountMap1.put(cell.getDateCellValue, amountCell.getNumericCellValue)
//        } else {
//          var amount: Double = dateToAmountMap1.get(amountCell.getDateCellValue)
//          amount += amountCell.getNumericCellValue
//          dateToAmountMap1.put(cell.getDateCellValue, amount)
//        }
//        //        } catch {
//        //          case e: Exception => System.out.println("Log tracer " + e.getLocalizedMessage)
//        //        }
//      }
//      i += 1
//    }
//
//      i = 0
//      while (i <= sheet2.getLastRowNum) {
//
//        val row1 = sheet2.getRow(i)
//
//        if (row1 != null
//          && row1.getCell(0) != null
//          && row1.getCell(0).getDateCellValue != null
//          && row1.getCell(2) != null
//          && row1.getCell(2) != null
//        ) {
//          val cell = row1.getCell(0)
//          val amountCell = row1.getCell(2)
////          try {
//
//            System.out.println("the value of " + amountCell.getNumericCellValue)
//            if (!dateToAmountMap2.containsKey(cell.getDateCellValue)) {
//              dateToAmountMap2.put(cell.getDateCellValue, amountCell.getNumericCellValue)
//            } else {
//              var amount : Double= dateToAmountMap2.get(amountCell.getDateCellValue)
//              amount += amountCell.getNumericCellValue
//              dateToAmountMap2.put(cell.getDateCellValue, amount)
//            }
////          } catch {
////            case e: Exception => System.out.println("Log tracer " + e.getLocalizedMessage)
////          }
//        }
//        i += 1
//      }
//
//      val firstIterator = dateToAmountMap1.entrySet().iterator()
//      val secondIterator = dateToAmountMap2.entrySet().iterator()
//
//      while(firstIterator.hasNext) {
//
//        val entry = firstIterator.next()
//
//        if(dateToAmountMap2.containsKey(entry.getKey)
//          && dateToAmountMap2.get(entry.getKey) != entry.getValue){
//          System.out.println("the value of entry not matching at date " + entry.getKey)
//          System.out.println("Unmatched entry is " + entry.getValue + " and " + dateToAmountMap2.get(entry.getKey))
//        }
//      }
//
//      while(secondIterator.hasNext) {
//
//        val entry = secondIterator.next()
//
//        if(dateToAmountMap1.containsKey(entry.getKey)
//          && dateToAmountMap1.get(entry.getKey) != entry.getValue){
//          System.out.println("the value of entry not matching at date " + entry.getKey)
//          System.out.println("Unmatched entry is " + entry.getValue + " and " + dateToAmountMap1.get(entry.getKey))
//        }
//      }
//  }
//}
