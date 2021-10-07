package io.codebyexample.kafkamultiplebrokers.core.usecase.user;


import io.codebyexample.kafkamultiplebrokers.core.entity.UserMessage;
import io.codebyexample.kafkamultiplebrokers.dataprovider.userkafka.UserKafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huypva
 * */
@Slf4j
@Component
public class UserUseCaseImpl implements UserUseCase {

  @Autowired
  UserKafkaProducer kafkaProducer;

  @Override
  public void greet(UserMessage user) {
    log.info("Greet user {} ", user.getUserId());

    kafkaProducer.sendUserMesage(user);
  }

  @Override
  public void goodbye(UserMessage user) {
    //do something
    log.info("Goodbye user {} with message {}", user.getUserId(), user.getMessage());
  }
}
