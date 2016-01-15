package src.main.scala.sample.domain.model.user

import javax.inject.Inject

import src.main.scala.sample.domain.model.DomainEventBus
import src.main.scala.sample.infra.persistence.database.user.UserDAO

class UserRepository @Inject()(userDAO: UserDAO) {

  def save(user: User): Boolean = {
    userDAO.save(user.userId.uuid, user.name, user.email, user.password, user.role) match {
      case true => {
        DomainEventBus.publish(new UserRegistered(user, 0))
        true
      }
      case _ => false
    }
  }

}