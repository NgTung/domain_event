package controllers

import javax.inject.Inject

import play.api.mvc._
import src.main.scala.sample.application.user.UserApplicationServices

class Application @Inject()(userApplicationServices: UserApplicationServices) extends Controller {

  def index = Action {
    userApplicationServices.register("tungnt", "tungnt@gmail.com", "123456789")

    Ok("Your new application is ready.")
  }

}