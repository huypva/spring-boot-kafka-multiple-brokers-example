package io.codebyexample.kafkamultiplebrokers.entrypoint.kafka;

import io.codebyexample.kafkamultiplebrokers.core.entity.BankMessage;
import io.codebyexample.kafkamultiplebrokers.core.entity.UserMessage;
import io.codebyexample.kafkamultiplebrokers.core.usecase.bank.BankUseCase;
import io.codebyexample.kafkamultiplebrokers.core.usecase.user.UserUseCase;
import io.codebyexample.kafkamultiplebrokers.utils.GsonUtils;
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
public class BankKafkaConsumer {

  @Autowired
  BankUseCase bankUseCase;

  @KafkaListener(topics = "BANK_TOPIC", groupId = "example",
      containerFactory = "bankKafkaListenerContainerFactory")
  public void consume(ConsumerRecord<String, String> record) {
    try {
      log.info(
          "Consumed - Partition: {} - Offset: {} - Value: {}",
          record.partition(),
          record.offset(),
          record.value());

      BankMessage bankMessage = GsonUtils.fromJson(record.value(), BankMessage.class);
      bankUseCase.processBanking(bankMessage);

    } catch (Exception ex) {
      log.error("Exception - Reason:", ex);
    }
  }
}
