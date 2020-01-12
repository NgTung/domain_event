package src.main.scala.sample.application.user

import java.util.UUID

import com.google.inject.{Guice, Inject, Injector}
import src.main.scala.sample.domain.model.DomainEventBus
import src.main.scala.sample.domain.model.user.event.{UserRegistered, UserRegisteredSubscriber}
import src.main.scala.sample.domain.model.user.{User, UserId, UserRepository}
import src.main.scala.sample.infra.encrypt.{EncryptProvider, Encryptable}
import net.codingwell.scalaguice.InjectorExtensions._
import src.main.scala.sample.infra.broker.{Event, EventSubscriber}

class UserService @Inject()(domainEventBus: DomainEventBus) extends UserRegisteredSubscriber {
  val userRepository = new UserRepository

  val encryptInjector: Injector = Guice.createInjector(new EncryptProvider)
  val encryptService: Encryptable = encryptInjector.instance[Encryptable]

  domainEventBus.subscribe(this.asInstanceOf[EventSubscriber[Event]])

  def register(username: String, email: String, password: String): Either[Throwable, Boolean] = {
    val userID = UserId(UUID.randomUUID())
    val newUser = User(userId = userID, username, email, encryptService.encrypt(password))
    val saved = userRepository.save(newUser)

    if (saved) {
      Right(true)
    } else {
      Left(new Exception("Can't save user"))
    }
  }

  override def handler(event: UserRegistered): Unit = register(event.user.name, event.user.email, event.user.password)
}
