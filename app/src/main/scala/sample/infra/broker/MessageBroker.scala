package src.main.scala.sample.infra.broker

import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule
import src.main.scala.sample.infra.broker.akka.AkkaEventBus

class MessageBroker extends AbstractModule with ScalaModule {

  override def configure(): Unit = {
    bind[MessagePublisher].to[AkkaEventBus]
  }

}
