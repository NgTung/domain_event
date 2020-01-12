package src.main.scala.sample.infra.persistence.database.user.impl

import org.joda.time.DateTime
import scalikejdbc._
import src.main.scala.sample.infra.persistence.database.user.{UserDAO, UserRecord}

import scala.util.{Success, Try}

class UserDAOMysqlImpl extends UserDAO {
  private val userTable = new UserTableRecord

  implicit private val session: DBSession = AutoSession

  def save(record: UserRecord): Boolean = {
    Try {
      println(s"saving user ${record.email} to DB")
      withSQL {
        val dbColumn = userTable.column

        insert.into(userTable).namedValues(
          dbColumn.id -> record.id,
          dbColumn.name -> record.name,
          dbColumn.email -> record.email,
          dbColumn.password -> record.password,
          dbColumn.createdAt -> DateTime.now
        )
      }.update.apply
    } match {
      case Success(affectedRow) if affectedRow > 0 => true
      case _ => false
    }
  }

}