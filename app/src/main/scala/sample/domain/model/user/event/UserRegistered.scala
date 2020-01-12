package src.main.scala.sample.domain.model.user.event

import src.main.scala.sample.domain.model.user.User

final case class UserRegistered(user: User) extends UserEvent {

  override var version: Long = System.currentTimeMillis()

}