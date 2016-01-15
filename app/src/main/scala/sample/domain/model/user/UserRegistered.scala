package src.main.scala.sample.domain.model.user

final case class UserRegistered(user: User, v: Long) extends UserEvent {
  override var version: Long = v
}