package src.main.scala.sample.domain.model

import com.google.inject.Guice
import src.main.scala.sample.infra.broker.{Event, EventSubscriber, MessageBroker, MessagePublisher}
import net.codingwell.scalaguice.InjectorExtensions._

class DomainEventBus {
  private val injector = Guice.createInjector(new MessageBroker())
  private val provider = injector.instance[MessagePublisher]

  def subscribe(subscriber: EventSubscriber[Event]): Unit = provider.subscribe(subscriber)

  def publish(event: Event): Unit = provider.publish(event)
}