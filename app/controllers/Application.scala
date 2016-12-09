package controllers

import learning._
import org.apache.spark.SparkContext
import play.api._
import play.api.mvc._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class Application(sparkContext: SparkContext) extends Controller {

  def index = Action {
    Redirect(routes.Application.hello())
  }

  def hello = Action {
    Future{
      HelloWorld.main(new Array[String](0), sparkContext)
    }
    Ok(views.html.index("Your new application is ready."))
  }

  def insert = Action {
    Future{
      println("***********Insert************")
      Insert.main(new Array[String](0), sparkContext)
    }
    Ok(views.html.index("Your new application is ready."))
  }

  def group = Action {
    Future{
      println("***********Grouping************")
      Grouping.main(new Array[String](0), sparkContext)
    }
    Ok(views.html.index("Your new application is ready."))
  }

  def groupBy = Action {
    Future{
      println("***********GroupBy************")
      //new GroupByKeyIterator[]()
    }
    Ok(views.html.index("Your new application is ready."))
  }

  def join = Action {
    Future{
      println("***********Join************")
      Join.main(new Array[String](0), sparkContext)
    }
    Ok(views.html.index("Your new application is ready."))
  }

  def broadcastJoin = Action {
    Future{
      println("***********BroadcastJoin************")
      BroadcastJoin.main(new Array[String](0), sparkContext)
    }
    Ok(views.html.index("Your new application is ready."))
  }

  def partitionGrouping = Action {
    Future{
      println("***********Partition Grouping************")
      PartitionGrouping.main(new Array[String](0), sparkContext)
    }
    Ok(views.html.index("Your new application is ready."))
  }

}