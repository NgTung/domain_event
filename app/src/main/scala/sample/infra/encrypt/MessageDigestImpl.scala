package src.main.scala.sample.infra.encrypt

import java.security
import java.security.MessageDigest

class MessageDigestImpl extends Encryptable {
  val messageDigest: security.MessageDigest = MessageDigest.getInstance("SHA-256")

  override def encrypt(message: String): String = {
    messageDigest.update(message.getBytes())
    messageDigest.digest().toString
  }
}
