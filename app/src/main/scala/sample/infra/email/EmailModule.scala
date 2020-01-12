package src.main.scala.sample.infra.email

import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule

class EmailModule extends AbstractModule with ScalaModule {

  override def configure(): Unit = {
    bind[EmailProvider].to[GmailProvider]
  }

}
