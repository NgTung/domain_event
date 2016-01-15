package src.main.scala.sample.infra.broker

import src.main.scala.sample.infra.broker.akka.AkkaEventBus

trait MessagePublisher {
  def subscribe(subscriber: EventSubscriber[Event])

  def publish(event: Event)
}

object MessagePublisher {

  def apply(provider: String): MessagePublisher = provider match {
    case "akka" => AkkaEventBus
    case _ => throw new Exception("Provider doesn't exists")
  }

  // an alternative factory method (use one or the other)
  def getProvider(provider: String): MessagePublisher = apply(provider)

}