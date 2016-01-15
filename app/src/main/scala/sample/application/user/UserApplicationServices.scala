package src.main.scala.sample.application.user

import com.google.inject.Inject
import src.main.scala.sample.domain.model.user.UserDomainServices

class UserApplicationServices @Inject()(userDomainServices: UserDomainServices) {
  def register(username: String, email: String, password: String) = {
    userDomainServices.register(username, email, password)
  }
}
