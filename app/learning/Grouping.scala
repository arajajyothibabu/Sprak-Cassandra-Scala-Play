package learning

import org.apache.spark.{SparkConf, SparkContext}
import com.datastax.spark.connector._

/**
  * Created by jyothi on 6/12/16.
  */
object Grouping {

  def main(args: Array[String], sc: SparkContext): Unit = {

    val visits = sc.cassandraTable[(String)]("test", "user_visits").
      select("user")

    val visitsPerUser = visits.map { user =>
      (user, 1)
    }.reduceByKey(_ + _)

    val maxVisits = visitsPerUser.values.max

    sc.stop

    println(maxVisits)
  }

}
