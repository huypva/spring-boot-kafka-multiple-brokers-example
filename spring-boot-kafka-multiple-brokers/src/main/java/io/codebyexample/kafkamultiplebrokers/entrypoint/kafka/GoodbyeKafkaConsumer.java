package io.codebyexample.kafkamultiplebrokers.entrypoint.kafka;

import io.codebyexample.springbootkafka.core.entity.UserMessage;
import io.codebyexample.springbootkafka.core.usecase.example.UserUseCase;
import io.codebyexample.springbootkafka.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author huypva
 * */
@Slf4j
@Service
public class GoodbyeKafkaConsumer {

  @Autowired
  UserUseCase userUseCase;

  @KafkaListener(topics = "UserMessage", groupId = "example")
  public void consume(ConsumerRecord<String, String> record) {
    try {
      log.info(
          "Consumed - Partition: {} - Offset: {} - Value: {}",
          record.partition(),
          record.offset(),
          record.value());

      UserMessage userMessage = GsonUtils.fromJson(record.value(), UserMessage.class);
      userUseCase.goodbye(userMessage);

    } catch (Exception ex) {
      log.error("Exception - Reason:", ex);
    }
  }
}
