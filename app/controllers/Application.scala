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
      Insert.main(new Array[String](0), sparkContext)
    }
    Ok(views.html.index("Your new application is ready."))
  }

  def group = Action {
    Future{
      Grouping.main(new Array[String](0), sparkContext)
    }
    Ok(views.html.index("Your new application is ready."))
  }

  def groupBy = Action {
    Future{
      //new GroupByKeyIterator[]()
    }
    Ok(views.html.index("Your new application is ready."))
  }

  def join = Action {
    Future{
      Join.main(new Array[String](0), sparkContext)
    }
    Ok(views.html.index("Your new application is ready."))
  }

  def broadcastJoin = Action {
    Future{
      BroadcastJoin.main(new Array[String](0), sparkContext)
    }
    Ok(views.html.index("Your new application is ready."))
  }

  def partitionGrouping = Action {
    Future{
      PartitionGrouping.main(new Array[String](0), sparkContext)
    }
    Ok(views.html.index("Your new application is ready."))
  }

}