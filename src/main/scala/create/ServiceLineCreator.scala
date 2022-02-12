package create

import java.io.{BufferedWriter, File, FileWriter}

class ServiceLineCreator(kpName: String ) {

  var line = "40I,1420160530001,{lineNum},0121,HC,C1727,,,,,,5000.00,UN,3,5000.00,,,,,472,RD8,20160501-20160510,6R,12345,,,,,,\n433,140000000123001,1212,5000,HC,C1727,AD,AE,AF,AG,,0022,18,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,573,D8,20160515,,\n432,140000000123001,12123,5000,HC,C1727,AD,AE,AF,AG,,0022,18,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,573,D8,20160515,,\n431,1420160530001,22222,5000,,HC,C1727,,,,,,0121,3,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,573,D8,20160510,,"

  var header : String = "00,EMCSV,1.5.3,BatchID,Medical,20160101,S-LA Source,S-LA\n100,142014053000,02,InstClaim,S-LA Source,S-LA,LA-DHH-MEDICAID,ContractID,LA-DHH-MEDICAID,False,,,,False,False,False,False,CL,,1420160530,41,2,MCO Plan,LB,123456789A,IC,ROBERT WHITE,TE,5703449237,EM,support@Edifecs.com,40,2,MEDICAID STATE,46,APPCSVNTEST1,BI,PXC,282N00000X,85,2,SEATTLE CHILDRENS HOSP,BillFirstName,BillMiddleName,BillSuff,XX,1205481405,4800 SAND POINT WAY,Bill Address 2,SEATTLE,WA,981051111,US,EI,503589555,G2,,0B,80,IC,MARIAH PEA,TE,7574567890,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,P\n150,142016053000,S,18,2222222,,MC,IL,1,DOE,JOHN,T,,MI,{rand_2_n:13},,,,,123 N MAIN ST,APT 1,ANYCITY,VA,23456,,D8,19900813,M,0F,{rand_0_n:10},F6,7894561234,PR,2,MCOPLAN,PI,300119960,116 16TH ST,SUITE A,BELLEVUE,WA,98001,,,,,,,,,,,\n20I,142016053000,{cl_0},{total}.00,13,A,1,A,Y,Y,,,,,434,RD8,20160501-20160510,,,,,,,1,6,01,02,,,02,,,,,9A,123ABC,,,,,9A,0123456789,,,EA,9875,,,,,,,,,,,,,,ABK,A000,Y,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,DR,,001,,,ABF,A011,Y,ABF,A012,Y,ABF,A013,Y,ABF,A014,Y,ABF,A020,Y,ABF,A021,Y,ABF,A0220,Y,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,BH,11,D8,20160501,BH,42,D8,20160501,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,BE,01,500000,BE,24,294600,BE,80,300,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,BG,C5,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,71,1,LAKIN,WILLIAM,,,XX,1760431167,AT,PXC,208D00000X,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,G2,1234567,,,,,,,,,,,,,,20170505,,12345678901234567890\n330,14000000012300,A,18,,,,ZZ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,D,{total}.00,,,,,Y,,Y,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,IL,1,CHANDLER,LYNN,,,MI,222229999B,404 COBBLEWOOD ARCH,,CHESAPEAKE,MD,233202222,,PR,2,MEDICARE COMPANY,PI,H08460,203 Street,,Washington,KY,405124601,,,,20160501,,,,,,,,,,\n320,14000000012300,T,18,,,,MB,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,D,{total}.00,,,,,Y,,Y,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,IL,1,CHANDLER,LYNN,,,MI,222229999A,404 COBBLEWOOD ARCH,,CHESAPEAKE,MD,233202222,,PR,2,MEDICARE COMPANY,PI,H08460,203 Street,,Washington,KY,405124601,,,,20160501,,,,,,,,,,\n310,142016053000,P,18,2222222,,,,,MC,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,D,{total}.00,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,IL,1,DOE,JOHN,,,MI,22222,123 MAIN ST,APT 1,ANYCITY,VA,23456,,PR,2,MCO PLAN,PI,300119960,116TH ST,,BELLEVUE,VA,98765,,573,D8,20160510,2U,2U,12345,G1,12345,9F,12345,T4,12345,F8,12345 "

  var lineSequence = 1
  var code = 700
  var footer = "01,TRT,0,0,1"

  def create(claimType: String,numberOfLines: Int): Unit = {


    val outputPath: String = getClass.getResource("../output").getPath
    val outputFile : File = new File(outputPath + "/" + kpName + "/" + claimType + numberOfLines + ".dat")
    if(!outputFile.exists()) outputFile.createNewFile()
    val bw = new BufferedWriter(new FileWriter(outputFile))

    var total = 5000 * numberOfLines
    val newHeader = header.replace("{total}", total.toString)
    bw.write(newHeader)
    bw.write("\n")

    for(index  <- 0 until numberOfLines) {

      var newLine = line.replace("{num}",code.toString)
      code = code + 1
      var finalLine = newLine.replace("{lineNum}",lineSequence.toString)
      lineSequence = lineSequence + 1
      bw.write(finalLine)
      bw.write("\n")
    }

    bw.write(footer)
    bw.close()
  }





}
