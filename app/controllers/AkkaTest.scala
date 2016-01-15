package controllers

import src.main.scala.sample.infra.broker.Event

case class AkkaTestEvent(name: String) extends Event {
  override var version: Long = 0
}
case class AkkaTestEvent2(name: String) extends Event {
  override var version: Long = 0
}

object AkkaTest {
  def eventHandler(event: Event): Unit = {
    if(event.isInstanceOf[AkkaTestEvent])  {
      print("hahaha")
    }
  }
}