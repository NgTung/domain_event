package src.main.scala.sample.infra.persistence.database.user

import org.joda.time.DateTime
import src.main.scala.sample.infra.persistence.database.Record

case class UserRecord(
  id: String,
  name: String,
  email: String,
  password: String,
  createdAt: DateTime = DateTime.now()
) extends Record