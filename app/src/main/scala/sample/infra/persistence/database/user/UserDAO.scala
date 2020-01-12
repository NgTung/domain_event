package src.main.scala.sample.infra.persistence.database.user

import src.main.scala.sample.infra.persistence.database.DAO

trait UserDAO extends DAO[UserRecord] {

  def save(record: UserRecord): Boolean

}
