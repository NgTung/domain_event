package src.main.scala.sample.infra.persistence.database.user.impl

import scalikejdbc.{ResultName, WrappedResultSet}
import src.main.scala.sample.infra.persistence.database.user.UserRecord
import scalikejdbc._

class UserTableRecord extends SQLSyntaxSupport[UserRecord] {
  override val tableName = "users"

  def apply(u: ResultName[UserRecord])(rs: WrappedResultSet): UserRecord = {
    UserRecord(
      id = rs.string(u.id),
      name = rs.string(u.name),
      email = rs.string(u.email),
      password = rs.string(u.password),
      createdAt = rs.jodaDateTime(u.id)
    )
  }
}