package src.main.scala.sample.domain.model

import src.main.scala.sample.infra.broker.{MessagePublisher, EventSubscriber, Event}

private [domain] object DomainEventBus {
  val messagePublisher = MessagePublisher.getProvider("akka")

  def subscribe(subscriber: EventSubscriber[Event]) = {
    messagePublisher.subscribe(subscriber)
  }

  def publish(event: Event) = {
    messagePublisher.publish(event)
  }
}