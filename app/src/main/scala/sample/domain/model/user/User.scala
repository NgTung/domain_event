package src.main.scala.sample.domain.model.user

import java.util.UUID

case class UserId(uuid: UUID) {
  override def toString = uuid.toString
}

case class User(userId: UserId, name: String, email: String, password: String, role: String)