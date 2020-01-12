package src.main.scala.sample.infra.persistence.database

trait DAO[T <: Record] {

  def save(record: T): Boolean

}
