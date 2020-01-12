package src.main.scala.sample.infra.broker

trait MessageBroker {
  def subscribe(subscriber: EventSubscriber[Event])

  def publish(event: Event)
}

