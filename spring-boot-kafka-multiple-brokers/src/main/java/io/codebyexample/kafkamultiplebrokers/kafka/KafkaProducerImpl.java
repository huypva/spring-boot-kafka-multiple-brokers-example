package io.codebyexample.kafkamultiplebrokers.kafka;

import io.codebyexample.springbootkafka.core.entity.UserMessage;
import io.codebyexample.springbootkafka.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author huypva
 * */
@Slf4j
@Service
public class KafkaProducerImpl implements KafkaProducer {

  @Autowired
  KafkaTemplate<String, String> userKafka;

  @Override
  public void sendUserMesage(UserMessage message) {
    userKafka.send("UserMessage", GsonUtils.toJson(message))
        .addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

          @Override
          public void onSuccess(SendResult<String, String> result) {
            log.info("Kafka sent message='{}' with offset={}", message,
                result.getRecordMetadata().offset());
          }

          @Override
          public void onFailure(Throwable ex) {
            log.error("Kafka unable to send message='{}'", message, ex);
          }
        });
  }

}
