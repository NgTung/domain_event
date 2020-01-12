package src.main.scala.sample.infra.broker

trait MessagePublisher {
  def subscribe(subscriber: EventSubscriber[Event])

  def publish(event: Event)
}

