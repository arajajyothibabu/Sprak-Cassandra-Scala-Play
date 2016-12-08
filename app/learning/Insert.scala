package learning

import org.apache.spark.rdd.RDD
import com.datastax.spark.connector._
import org.apache.spark.{SparkConf, SparkContext}
import utils.CassandraWithSparkContext

import scala.util.Random

/**
  * Created by jyothi on 6/12/16.
  */
object Insert {

  def randomStores(sc: SparkContext, stores: Int, cities: Int): RDD[(String, String, String)] = {
    println("storing to stores")
    sc.parallelize(0 until stores).map { s =>
      val city = s"city_${Random.nextInt(cities)}"

      val store = s"store_${s}"

      val manager = s"manager_${Math.abs(Random.nextInt)}"
      println(city + ":" + store + ":" + manager)
      (city, store, manager)
    }
  }

  def randomVisits(sc: SparkContext, users: Int, stores: Int, visitsPerUser: Int): RDD[(String, Long, String)] = {
    println("Storing to user_visits")
    sc.parallelize(0 until users).flatMap { u =>
      val user = s"user_${u}"

      (1 to visitsPerUser).map { v =>
        val utcMillis = System.currentTimeMillis - Random.nextInt

        val store = s"store_${Random.nextInt(stores)}"
        println(user + ":" + utcMillis + ":" + store)
        (user, utcMillis, store)
      }
    }
  }

  def main(args: Array[String], sc: SparkContext): Unit = {

    val numStores = 128

    println("number of stores:: " + numStores)

    randomStores(sc, stores = numStores, cities = 32).
      saveToCassandra("test", "stores", SomeColumns("city", "store", "manager"))

    randomVisits(sc, users = 16384, visitsPerUser = 128, stores = numStores).
      saveToCassandra("test", "user_visits", SomeColumns("user", "utc_millis", "store"))

    //sc.stop
  }

}
