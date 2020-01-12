package src.main.scala.sample.infra.encrypt

import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule

class EncryptProvider extends AbstractModule with ScalaModule {

  override def configure(): Unit = {
    bind[Encryptable].to[MessageDigestImpl]
  }

}
