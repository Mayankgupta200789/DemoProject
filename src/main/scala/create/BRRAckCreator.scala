package create

import java.io.{BufferedWriter, File, FileWriter}

import scala.io.Source

class BRRAckCreator {

  var header:String = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n\n<head>\n    <title>Claim File Submission Error Report</title>\n    <style type=\"text/css\">\n        body: {\n            margin-top: 0px;\n        }\n        \n        table.base {\n            width: 1000px;\n            font-family: arial, helvetica;\n            font-size: 10pt;\n            border: solid 1px #DCDCDC;\n            border-collapse: collapse;\n        }\n        \n        table.report-info {\n            border: none\n        }\n        \n        table.file-info {}\n        \n        table.claim-info {\n            margin-left: 20px;\n            width: 980px\n        }\n        \n        table.error-info {\n            margin-left: 40px;\n            width: 960px\n        }\n        \n        td.field {\n            font-weight: bold;\n            white-space: nowrap;\n            padding: 4px 6px;\n            width: 25%;\n        }\n        \n        td.value {\n            padding: 4px 6px;\n            width: 25%;\n        }\n        \n        td.wideval {\n            padding: 4px 6px;\n            width: 75%;\n        }\n        \n        tr.odd {\n            background-color: #F8F8FF\n        }\n        \n        tr.even {\n            background-color: #FCFCFC\n        }\n        \n        .poweredby {\n            padding: 5;\n            text-align: right;\n            font-style: italic;\n            vertical-align: top\n        }\n        \n        .report-title {\n            font-size: 20pt;\n            padding-top: 10px;\n            padding-bottom: 10px\n        }\n        \n        .file-info-title {\n            font-size: 14pt;\n            padding: 20px 0px\n        }\n        \n        .claim-info-title {\n            font-size: 14pt;\n            margin-left: 20px;\n            padding: 20px 0px\n        }\n        \n        .error-info-title {\n            font-size: 14pt;\n            margin-left: 40px;\n            padding: 20px 0px\n        }\n        \n        .total-rejections-title {\n            font-size: 14pt;\n            padding: 10px 0px\n        }\n        \n        .title {\n            font-family: arial, helvetica;\n            font-weight: bold;\n            color: Navy;\n            padding-left: 5px\n        }\n    </style>\n</head>\n\n<body>\n    <table class=\"report-info base\">\n        <tr>\n            <td>\n                <div class=\"report-title title\">Claim File Submission Error Report</div>\n            </td>\n            <td class=\"poweredby\" />\n        </tr>\n    </table>\n    <div class=\"file-info-title title\">File Information:</div>\n    <table class=\"file-info base\">\n        <tr class=\"odd\">\n            <td class=\"field\">Sender ID:</td>\n            <td class=\"value\">WVFHP5010 </td>\n            <td class=\"field\">Transaction Type:</td>\n            <td class=\"value\">005010X222A1</td>\n        </tr>\n        <tr class=\"even\">\n            <td class=\"field\">Receiver ID:</td>\n            <td class=\"value\">WV_MMIS_4MOLINA</td>\n            <td class=\"field\">Usage Indicator:</td>\n            <td class=\"value\">P</td>\n        </tr>\n        <tr class=\"odd\">\n            <td class=\"field\">Date / Time:</td>\n            <td class=\"value\">{date_yyyyMMdd} / 0259</td>\n            <td class=\"field\">Transaction Control Number:</td>\n            <td class=\"value\">WVTPID000001{encounter_InterchangeControlNumber:EHCPInterchange_0_0_0}WV_MMIS_4MOLINA</td>\n        </tr>\n    </table>"


  var footer: String = "<div class=\"claim-info-title title\">Claim Information:</div>\n    <table class=\"claim-info base\">\n        <tr class=\"odd\">\n            <td class=\"field\">Billing Provider:</td>\n            <td class=\"value\">PRESTERA CENTER FOR MENTAL HEALTH SERVICES INC.</td>\n            <td class=\"field\">Claim Number:</td>\n            <td class=\"value\">{en_0_0}</td>\n        </tr>\n        <tr class=\"even\">\n            <td class=\"field\">Billing Provider Qualifier, ID:</td>\n            <td class=\"value\">XX, 1356336903</td>\n            <td class=\"field\">Service Date:</td>\n            <td class=\"value\">{date_yyyyMMdd}-{date_yyyyMMdd}</td>\n        </tr>\n        <tr class=\"odd\">\n            <td class=\"field\">Billing Provider Secondary Qualifier, ID:</td>\n            <td class=\"value\">n/a</td>\n            <td class=\"field\">Claim Charges:</td>\n            <td class=\"value\">56.48</td>\n        </tr>\n        <tr class=\"even\">\n            <td class=\"field\">Subscriber:</td>\n            <td class=\"value\">BRENDAN, CLARK</td>\n            <td class=\"field\">Transaction Set:</td>\n            <td class=\"value\">1990</td>\n        </tr>\n        <tr class=\"odd\">\n            <td class=\"field\">Subscriber Qualifier, ID:</td>\n            <td class=\"value\">, 00701671583</td>\n            <td class=\"field\" />\n            <td class=\"value\" />\n        </tr>\n    </table>\n    <div class=\"error-info-title title\">Transaction Error(s):</div>\n    <table class=\"error-info base\">\n        <tr class=\"odd\">\n            <td class=\"field\">Error Number:</td>\n            <td class=\"wideval\">1</td>\n        </tr>\n        <tr class=\"even\">\n            <td class=\"field\">Error ID:</td>\n            <td class=\"wideval\">0x9999349</td>\n        </tr>\n        <tr class=\"odd\">\n            <td class=\"field\">Error Summary:</td>\n            <td class=\"wideval\">Custom Validation Rule Failure</td>\n        </tr>\n        <tr class=\"even\">\n            <td class=\"field\">Error Message:</td>\n            <td class=\"wideval\">No Member on File.</td>\n        </tr>\n        <tr class=\"odd\">\n            <td class=\"field\">Data in Error:</td>\n            <td class=\"wideval\">00701671583</td>\n        </tr>\n        <tr class=\"even\">\n            <td class=\"field\">Error Location:</td>\n            <td class=\"wideval\">n/a</td>\n        </tr>\n    </table><br />\n    <div class=\"total-rejections-title title\">Total Transaction Rejections: 2</div>\n</body>\n\n</html>"


  def create(kpName: String, ackType: String): Unit = {

    val path: String = getClass.getResource("../claim/" + kpName + "/" + ackType + ".html").getPath
    val inputFile = new File(path)

    val outputPath: String = getClass.getResource("../output").getPath
    val outputFile : File = new File(outputPath + "/" + kpName + "/" + ackType + ".html")

    val bw : BufferedWriter = new BufferedWriter(new FileWriter(outputFile))

    val listOfEncounters = 5000
    var claimId = 844610124
    bw.write(header)
    bw.write("\n")

    for(index  <- 0 until listOfEncounters) {

      val source = Source.fromFile(inputFile)
      for (lines <- source.getLines()){

        if(lines.contains("{en_0_0}")) {
            claimId += 1
            lines.replace("{en_0_0}",claimId.toString)
        }

        bw.write(lines)
      }
    }
    bw.write("\n")

    bw.write(footer)
    bw.close()
  }

}
