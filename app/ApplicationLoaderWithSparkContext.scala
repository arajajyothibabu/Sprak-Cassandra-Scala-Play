import play.api._
import play.api.ApplicationLoader.Context
import router.Routes
import utils.CassandraWithSparkContext

/**
  * Created by jyothi on 6/12/16.
  */

class ApplicationLoaderWithSparkContext extends ApplicationLoader{

  def load(context: Context) = {
    new CustomLoader(context).application
  }

}

class CustomLoader(context: Context) extends BuiltInComponentsFromContext(context) with CassandraWithSparkContext {

  lazy val router = new Routes(httpErrorHandler, applicationController, assets)
  lazy val applicationController = new controllers.Application(getSparkContext(new Array[String](0))) //Injecting SparkContext
  lazy val assets = new controllers.Assets(httpErrorHandler)

}
