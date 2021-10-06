package io.codebyexample.kafkamultiplebrokers.core.usecase.example;

import io.codebyexample.springbootkafka.core.entity.UserMessage;
import io.codebyexample.springbootkafka.dataprovider.messaging.kafka.KafkaProducer;
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
  KafkaProducer kafkaProducer;

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
