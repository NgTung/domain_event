package src.main.scala.sample.domain.model.user

class DemoRepository extends UserRegisteredSubscriber {

  override def handler(event: UserRegistered): Unit = {
    println("User Registered!!!")
  }

}
