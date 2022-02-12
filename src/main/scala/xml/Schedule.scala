package com.edifecs.em.analytics.etl.xml

/**
 * Created by c-serggonc on 4/13/2016.
 */
case class Schedule(val seconds: String, val minutes: String, val hours: String, val dayOfMonth: String, val month: String, val dayOfWeek: String, val year: String)

object Schedule {
  val SCHEDULE_ELEMENT = "Schedule"
  val SECONDS_ELEMENT = "Seconds"
  val MINUTES_ELEMENT = "Minutes"
  val HOURS_ELEMENT = "Hours"
  val DAYOFMONTH_ELEMENT = "DayOfMonth"
  val MONTH_ELEMENT = "Month"
  val DAYOFWEEK_ELEMENT = "DayOfWeek"
  val YEAR_ELEMENT = "Year"
}
