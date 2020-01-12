package src.main.scala.sample.domain.model

import com.google.inject.Guice
import src.main.scala.sample.infra.broker.{Event, EventSubscriber, MessageBrokerModule, MessageBroker}
import net.codingwell.scalaguice.InjectorExtensions._

class DomainEventBus {
  private val injector = Guice.createInjector(new MessageBrokerModule)
  private val broker = injector.instance[MessageBroker]

  def subscribe(subscriber: EventSubscriber[Event]): Unit = broker.subscribe(subscriber)

  def publish(event: Event): Unit = broker.publish(event)
}