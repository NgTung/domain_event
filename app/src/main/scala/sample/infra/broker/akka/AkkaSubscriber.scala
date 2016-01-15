package src.main.scala.sample.infra.broker.akka

import akka.actor.Actor
import src.main.scala.sample.infra.broker.Event

class AkkaSubscriber(f: Event => Unit) extends Actor {
  override def receive = {
    case event: Event => f(event)
    case _ =>
  }
}