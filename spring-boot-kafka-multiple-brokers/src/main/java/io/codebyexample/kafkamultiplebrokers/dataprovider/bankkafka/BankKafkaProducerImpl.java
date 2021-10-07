package io.codebyexample.kafkamultiplebrokers.dataprovider.bankkafka;

import io.codebyexample.kafkamultiplebrokers.core.entity.BankMessage;
import io.codebyexample.kafkamultiplebrokers.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author huypva
 * */
@Slf4j
@Service
public class BankKafkaProducerImpl implements BankKafkaProducer {

  @Autowired
  @Qualifier("bankKafkaTemplate")
  KafkaTemplate<String, String> bankKafkaTemplate;

  @Override
  public void sendBankMessage(BankMessage bankMessage) {
    bankKafkaTemplate.send("BANK_TOPIC", GsonUtils.toJson(bankMessage))
        .addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

          @Override
          public void onSuccess(SendResult<String, String> result) {
            log.info("Kafka sent message='{}' with offset={}", GsonUtils.toJson(bankMessage),
                result.getRecordMetadata().offset());
          }

          @Override
          public void onFailure(Throwable ex) {
            log.error("Kafka unable to send message='{}'", GsonUtils.toJson(bankMessage), ex);
          }
        });
  }

}
