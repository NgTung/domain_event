package src.main.scala.sample.domain.model.user

import java.util.UUID
import javax.inject.Inject

import src.main.scala.sample.domain.model.DomainEventBus
import src.main.scala.sample.infra.broker.{Event, EventSubscriber}

class UserDomainServices @Inject()(demoRepository: DemoRepository, userRepository: UserRepository) {
  def register(username: String, email: String, password: String) = {
    DomainEventBus.subscribe(demoRepository.asInstanceOf[EventSubscriber[Event]])

    userRepository.save(User(userId = UserId(uuid = UUID.randomUUID()),username, email, password, role = "1"))
  }
}
