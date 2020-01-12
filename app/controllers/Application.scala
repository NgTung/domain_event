package controllers

import javax.inject.Inject
import play.api.mvc._
import src.main.scala.sample.application.RegisterApplication

class Application @Inject()(registerApplication: RegisterApplication) extends Controller {

  def index: Action[AnyContent] = Action {
    registerApplication.registerNewUser("tungnt", "tungnt@gmail.com", "123456789").fold(
      exception => InternalServerError(exception.getMessage),
      _ => Ok("created")
    )
  }

}