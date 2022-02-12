//
//
//import java.io.{File, FileInputStream, FileOutputStream}
//
//import com.cronutils.descriptor.CronDescriptor
//import com.cronutils.model.CronType
//import com.cronutils.model.definition.CronDefinitionBuilder
//import com.cronutils.parser.CronParser
//import com.edifecs.em.analytics.etl.xml.Schedule
//import org.apache.poi.xssf.usermodel.{XSSFRow, XSSFWorkbook}
//import java.util
//import util.{Locale}
//
//import scala.xml.{NodeSeq, XML}
//
//
//class ExcelWriter(var moduleName: String, var rowIndex : Int, var resourceName: String ) {
//
//  var columns = Array("headerValue", "etlname", "source", "target")
//
//  var files: List[File] = FileRetrieverUtil.getListOfFiles(getClass.getResource(resourceName).getPath)
//
//  val outpuResourceDirectory = "output/ETL.xlsx"
//
//
//  private val ENTITY = "Entity"
//
//  def write(): Unit = {
//
//
//    val workbook = new XSSFWorkbook(new FileInputStream(getClass.getResource(outpuResourceDirectory).getPath))
//
//    val sheet = workbook.getSheet("Sheet1")
//
//    var j = rowIndex
//
//    for (file: File <- files) {
//
//      val element = XML.load(file.getPath)
//
//      val etlNode = element \\ "ETL"
//
//      val scheduleNode = etlNode \\ "Schedule"
//
//      val entityNodes = etlNode \\ ENTITY
//
//
//      //TODO : MG : Remove this
//      val source = (etlNode \ "@source").text
//      val target = (etlNode \ "@target").text
//      val etlid = (etlNode \ "@id").text
//      var isEnabled = (etlNode \ "@enabled").text
//
//      if (isEnabled.equals("true")) {
//        isEnabled = "enabled"
//      } else {
//        isEnabled = "disabled"
//      }
//
//      val schedule = Schedule((scheduleNode \ Schedule.SECONDS_ELEMENT).text,
//        (scheduleNode \ Schedule.MINUTES_ELEMENT).text,
//        (scheduleNode \ Schedule.HOURS_ELEMENT).text,
//        (scheduleNode \ Schedule.DAYOFMONTH_ELEMENT).text,
//        (scheduleNode \ Schedule.MONTH_ELEMENT).text,
//        (scheduleNode \ Schedule.DAYOFWEEK_ELEMENT).text,
//        (scheduleNode \ Schedule.YEAR_ELEMENT).text)
//
//      val cronDescription = getCronDescription(schedule)
//
//      var targetTables = ""
//      if(file.getName.contains("Datamart.config.xml")) {
//
//        targetTables = getListOfTargetTablesFromDatamart(etlNode).replace("[","").replace("]","")
//      } else if ( file.getName.contains("em-analytics.config.xml")) {
//        targetTables = getListOfTargetTablesFromEmAnalytics(etlNode).replace("[","").replace("]","")
//      }
//      sheet.createRow(j)
//
//
//
//      val row = sheet.getRow(j)
//      val k = 0
//
//      var query = "Query"
//
//      if(file.getName.contains("Metadata")) {
//        query = "Metadata"
//      } else if ( file.getName.contains("BusinessItems")) {
//        query = "BizItem"
//      }
//
//      createCell(row, moduleName, k)
//      createCell(row, file.getName, k + 1)
//      createCell(row, etlid, k + 2)
//      createCell(row, query, k + 3)
//      createCell(row, isEnabled, k + 4)
//      createCell(row, cronDescription, k + 5)
//      createCell(row, targetTables, k + 7)
//      j = j + 1
//    }
//
//    val fos = new FileOutputStream(getClass.getResource(outpuResourceDirectory).getPath)
//
//
//    try {
//      workbook.write(fos)
//      fos.close()
//      workbook.close()
//    } catch {
//      case e: Exception => {
//        print(e)
//      }
//    }
//  }
//
//  private def createCell(header: XSSFRow, headerValue: String, columnIndex: Int) = {
//
//    val head = header.createCell(columnIndex)
//
//    head.setCellValue(headerValue)
//  }
//
//
//
//  def getCronDescription(schedule: Schedule): String = {
//    var cronDefinition = CronDefinitionBuilder.defineCron.withSeconds.and.withMinutes.and.withHours.and.withDayOfMonth.supportsHash.supportsL.supportsW.and.withMonth.and.withDayOfWeek.withIntMapping(7, 0).supportsHash //we support non-standard non-zero-based numbers!
//      .supportsL.supportsW.and.withYear.optional.and.instance
//    cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ)
//    val parser = new CronParser(cronDefinition)
//    val space = " "
//    var input = schedule.seconds + space + schedule.minutes + space + schedule.hours + space + schedule.dayOfMonth + space + schedule.month + space + schedule.dayOfWeek
//    if(!schedule.year.isEmpty) input = input + space + schedule.year
//    var output = ""
//    try {
//      val quartzCron = parser.parse(input)
//
//      val cronDescriptor = CronDescriptor.instance(Locale.US)
//      output = cronDescriptor.describe(quartzCron)
//    } catch {
//      case e: Exception => {
//       output = "Invalid Cron"
//      }
//    }
//    output
//  }
//
//  def getListOfTargetTablesFromDatamart(etlNode: NodeSeq): String = {
//    val entityNodes = etlNode \\ ENTITY
//    val list  = new util.ArrayList[String]()
//    entityNodes.foreach(entityNode => list.add((entityNode \ "@target").text))
//    list.toString
//  }
//
//  def getListOfTargetTablesFromEmAnalytics(etlNode: NodeSeq): String = {
//    val loadNodes = etlNode \\ "Load"
//    val list  = new util.ArrayList[String]()
//    for(loadNode <- loadNodes ) {
//        val processorNodes = loadNode \ "Processor"
//
//        for( processorNode <- processorNodes ) {
//          val entities = processorNode \ ENTITY
//
//          entities.foreach(entity => list.add((entity \ "@target").text))
//        }
//
//    }
//    list.toString
//  }
//}
