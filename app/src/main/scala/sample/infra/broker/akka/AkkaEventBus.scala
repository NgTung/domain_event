package src.main.scala.sample.infra.broker.akka

import akka.actor.{ActorRef, ActorSystem, Props}
import src.main.scala.sample.infra.broker.{Event, EventSubscriber, MessageBroker}

class AkkaEventBus extends MessageBroker {
  protected val system: ActorSystem = ActorSystem(AkkaConfig.APP_NAME)

  private def registerHandler(f: Event => Unit): Boolean = {
    val subscriber: ActorRef = system.actorOf(Props(classOf[AkkaSubscriber], f))

    system.eventStream.subscribe(subscriber, classOf[Event])
  }

  def publish(event: Event): Unit = system.eventStream.publish(event)

  override def subscribe(subscriber: EventSubscriber[Event]): Unit = registerHandler(subscriber.handler)
}