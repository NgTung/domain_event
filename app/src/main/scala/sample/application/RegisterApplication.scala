package src.main.scala.sample.application

import java.util.UUID

import src.main.scala.sample.application.email.EmailService
import src.main.scala.sample.application.user.UserService
import src.main.scala.sample.domain.model.DomainEventBus
import src.main.scala.sample.domain.model.user.{User, UserId}
import src.main.scala.sample.domain.model.user.event.UserRegistered

class RegisterApplication {
  val eventBus = new DomainEventBus
  val userServices = new UserService(eventBus)
  val emailService = new EmailService(eventBus)

  def registerNewUser(username: String, email: String, password: String): Either[Throwable, Boolean] = {
    val userCreatedEvent = UserRegistered(User(
      userId = UserId(UUID.randomUUID()),
      name = username,
      email = email,
      password = password
    ))
    // Fire user created event to all subscribers!!!
    eventBus.publish(userCreatedEvent)

    Right(true)
  }
}
