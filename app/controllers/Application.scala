package controllers

import learning.HelloWorld
import play.api._
import play.api.mvc._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class Application extends Controller {

  def index = Action {
    Redirect(routes.Application.hello())
  }

  def hello = Action {
    Future{
      HelloWorld.main(new Array[String](0))
    }
    Ok(views.html.index("Your new application is ready."))
  }

  def insert = Action {
    Future{
      HelloWorld.main(new Array[String](0))
    }
    Ok(views.html.index("Your new application is ready."))
  }

  def group = Action {
    Future{
      HelloWorld.main(new Array[String](0))
    }
    Ok(views.html.index("Your new application is ready."))
  }

  def groupBy = Action {
    Future{
      HelloWorld.main(new Array[String](0))
    }
    Ok(views.html.index("Your new application is ready."))
  }

  def join = Action {
    Future{
      HelloWorld.main(new Array[String](0))
    }
    Ok(views.html.index("Your new application is ready."))
  }

  def broadcastJoin = Action {
    Future{
      HelloWorld.main(new Array[String](0))
    }
    Ok(views.html.index("Your new application is ready."))
  }

  def partionGrouping = Action {
    Future{
      HelloWorld.main(new Array[String](0))
    }
    Ok(views.html.index("Your new application is ready."))
  }

}