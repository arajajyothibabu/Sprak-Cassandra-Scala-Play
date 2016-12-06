package learning

import org.apache.spark.{SparkConf, SparkContext}
import com.datastax.spark.connector._

/**
  * Created by jyothi on 6/12/16.
  */
object HelloWorld {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf(true)
      .setMaster("local[*]")
      .setAppName("SparkCassandraScalaPlay")

    val sc = new SparkContext(conf)

    val table = sc.cassandraTable[(String, String)]("test", "hello") //keySpace: test , table: hello

    println("Table:: " + table)

    val first = table.first()

    sc.stop //stop sparkContext here

    println("Table First Tuple:: " + first)

  }

}
