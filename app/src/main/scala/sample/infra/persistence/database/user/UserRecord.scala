package src.main.scala.sample.infra.persistence.database.user

import org.joda.time.DateTime
import scalikejdbc._

case class UserRecord(
 id: String,
 name: String,
 email: String,
 password: String,
 role: String,
 resigned: String,
 createdAt: DateTime
)

class UserTableRecord extends SQLSyntaxSupport[UserRecord] {
  override val tableName = "users"

  def apply(u: ResultName[UserRecord])(rs: WrappedResultSet): UserRecord = {
    UserRecord(
      id = rs.string(u.id),
      name = rs.string(u.name),
      email = rs.string(u.email),
      password = rs.string(u.password),
      role = rs.string(u.role),
      resigned = rs.string(u.resigned),
      createdAt = rs.jodaDateTime(u.id)
    )
  }
}