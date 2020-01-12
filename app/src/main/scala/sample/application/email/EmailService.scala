package src.main.scala.sample.application.email

import com.google.inject.{Guice, Injector}
import javax.inject.Inject
import src.main.scala.sample.infra.email.{EmailModule, EmailProvider}
import net.codingwell.scalaguice.InjectorExtensions._
import src.main.scala.sample.domain.model.DomainEventBus
import src.main.scala.sample.domain.model.user.event.{UserRegistered, UserRegisteredSubscriber}
import src.main.scala.sample.infra.broker.{Event, EventSubscriber}

class EmailService @Inject()(eventBus: DomainEventBus) extends UserRegisteredSubscriber {
  val emailModule = new EmailModule
  val emailInjector: Injector = Guice.createInjector(emailModule)
  val emailProvider: EmailProvider = emailInjector.instance[EmailProvider]

  eventBus.subscribe(this.asInstanceOf[EventSubscriber[Event]])

  override def handler(event: UserRegistered): Unit = emailProvider.send(
    subject = "Welcome Email",
    body = "Welcome to our system",
    to = List(event.user.email)
  )
}
