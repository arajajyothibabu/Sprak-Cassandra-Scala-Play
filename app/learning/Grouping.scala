package learning

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD
import com.datastax.spark.connector._

/**
  * Created by jyothi on 6/12/16.
  */
object Grouping {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("cassandra-example-grouping")

    val sc = new SparkContext(conf)

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
