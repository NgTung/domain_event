package src.main.scala.sample.domain.model.user

import com.google.inject.Guice
import src.main.scala.sample.domain.model.Repository
import src.main.scala.sample.infra.persistence.database.user.{UserDAO, UserPersistence, UserRecord}
import net.codingwell.scalaguice.InjectorExtensions._

class UserRepository extends Repository[User] {
  private val injector = Guice.createInjector(new UserPersistence())
  private val userDAO = injector.instance[UserDAO]

  override def save(user: User): Boolean = {
    userDAO.save(UserRecord(user.userId.uuid.toString, user.name, user.email, user.password))
  }
}