package src.main.scala.sample.infra.broker

trait EventSubscriber[E <: Event] {
  def handler(event: E)
}