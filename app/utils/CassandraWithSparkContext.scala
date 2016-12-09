package utils

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by jyothi on 6/12/16.
  */

trait CassandraWithSparkContext {

  def getSparkContext(args: Array[String]): SparkContext = {
    val conf = new SparkConf(true)
      .setMaster("local[*]")
      .setAppName("SparkCassandraScalaPlay")
      .set("spark.app.id", "SparkCassandraScalaPlay")
      .set("spark.cassandra.connection.host", "127.0.0.1") //we can set cassandra server name here

    val sc = new SparkContext(conf)
    sc
  }

}

