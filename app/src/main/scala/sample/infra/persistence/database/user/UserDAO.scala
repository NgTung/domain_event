package src.main.scala.sample.infra.persistence.database.user

import java.util.UUID

import org.joda.time.DateTime
import scalikejdbc._

class UserDAO {
  private val userTable = new UserTableRecord
  private val u = new UserTableRecord().syntax("u")

  def findById(id: UUID)(implicit session: DBSession = AutoSession): Option[UserRecord] = {
    withSQL {
      select
        .from(userTable as u)
        .where.eq(u.id, id.toString)
    }.map(userTable.apply(u.resultName)).single().apply()
  }

  def save(
    id: UUID,
    name: String,
    email: String,
    password: String,
    role: String)(implicit session: DBSession = AutoSession): Boolean = withSQL {
      val u = userTable.column
      insert.into(userTable).namedValues(
        u.id -> id.toString,
        u.name -> name,
        u.email -> email,
        u.password -> password,
        u.role -> role.toInt,
        u.createdAt -> DateTime.now
      )
    }.update.apply > 0

}