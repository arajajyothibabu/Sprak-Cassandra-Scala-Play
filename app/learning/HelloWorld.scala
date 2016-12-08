package learning

import com.datastax.spark.connector._
import org.apache.spark.SparkContext

/**
  * Created by jyothi on 6/12/16.
  */
object HelloWorld {

  def main(args: Array[String], sc: SparkContext): Unit = {

    val table = sc.cassandraTable[(String, String)]("test", "hello") //keySpace: test , table: hello

    println("Table:: " + table)

    val first = table.first()

    //sc.stop //stop sparkContext here

    println("Table First Tuple:: " + first)

  }

}
