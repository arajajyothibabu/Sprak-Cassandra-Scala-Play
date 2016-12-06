package learning

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD
import com.datastax.spark.connector._

/**
  * Created by jyothi on 6/12/16.
  */
object Join {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("cassandra-example-join")

    val sc = new SparkContext(conf)

    val visits = sc.cassandraTable[(String, String)]("test", "user_visits").
      select("store", "user")

    val stores = sc.cassandraTable[(String, String)]("test", "stores").
      select("store", "city")

    val visitsPerCity = visits.join(stores).map {
      case (store, (user, city)) => (city, 1)
    }.reduceByKey(_ + _)

    val result = visitsPerCity.collect

    sc.stop

    result.foreach(println)
  }

}
