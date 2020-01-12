package controllers

import javax.inject.Inject
import play.api.mvc._
import src.main.scala.sample.application.UserApplication

class Application @Inject()(userApplication: UserApplication) extends Controller {

  def index: Action[AnyContent] = Action {
    userApplication.registerNewUser("tungnt", "tungnt@gmail.com", "123456789").fold(
      exception => InternalServerError(exception.getMessage),
      _ => Created
    )
  }

}