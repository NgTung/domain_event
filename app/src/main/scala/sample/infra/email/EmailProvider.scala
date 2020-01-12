package src.main.scala.sample.infra.email

trait EmailProvider {

  def send(
    subject: String,
    body: String,
    to: List[String],
    cc: Option[List[String]] = None,
    bcc: Option[List[String]] = None
  ): Boolean

}
