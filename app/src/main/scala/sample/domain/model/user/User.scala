package src.main.scala.sample.domain.model.user

import java.util.UUID

import src.main.scala.sample.domain.model.Entity

case class UserId(uuid: UUID)

case class User(
  userId: UserId,
  name: String,
  email: String,
  password: String
) extends Entity