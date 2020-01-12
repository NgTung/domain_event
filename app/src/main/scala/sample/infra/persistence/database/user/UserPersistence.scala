package src.main.scala.sample.infra.persistence.database.user

import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule
import src.main.scala.sample.infra.persistence.database.user.impl.UserDAOMysqlImpl

class UserPersistence extends AbstractModule with ScalaModule {

  override def configure(): Unit = {
    bind[UserDAO].to[UserDAOMysqlImpl]
  }

}
