package src.main.scala.sample.domain.model

trait Repository[T <: Entity] {

  def save(entity: T): Boolean

}
