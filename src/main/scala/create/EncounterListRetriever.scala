package create

import java.sql.Connection
import java.sql.DriverManager._
import java.util

object EncounterListRetriever {


  def retrieve(sql : String): util.ArrayList[String] = {


    val outputList = new util.ArrayList[String]()

    val url = "jdbc:jtds:sqlserver://PNE-FIN90/gbdrepo;sendStringParametersAsUnicode=false"
    val userName = "sa"
    val pwd = "manager" // encrypted pwd

    var conn : Connection = connectMySql(url,userName,pwd)

    val statement = conn.createStatement

    val resultSet = statement.executeQuery(sql)

    while(resultSet.next()) {

      outputList.add(resultSet.getString("trackingidentifier"))
    }
    outputList
  }

  def connectMySql(url: String, user: String, password: String): Connection = {

    var conn : Connection = null
    try { //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      Class.forName("net.sourceforge.jtds.jdbc.Driver")
      conn = getConnection(url,user,password)

    } catch {
      case e: Exception =>

    }
    conn
  }

}
