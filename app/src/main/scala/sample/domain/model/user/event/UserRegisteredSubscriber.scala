package src.main.scala.sample.domain.model.user.event

import src.main.scala.sample.infra.broker.EventSubscriber

abstract class UserRegisteredSubscriber extends EventSubscriber[UserRegistered] {
  private def className[A](a: A)(implicit m: Manifest[A]) = m.toString
  override def toString = className(this)

  override def handler(event: UserRegistered)
}