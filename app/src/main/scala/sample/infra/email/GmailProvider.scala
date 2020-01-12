package src.main.scala.sample.infra.email

class GmailProvider extends EmailProvider {
  override def send(subject: String, body: String, to: List[String], cc: Option[List[String]], bcc: Option[List[String]]): Boolean = {
    println(s"Sent email to ${to.mkString(", ")}")
    true
  }
}
