package io.codebyexample.kafkamultiplebrokers.dataprovider.userkafka;

import io.codebyexample.kafkamultiplebrokers.core.entity.UserMessage;
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
public class UserKafkaProducerImpl implements UserKafkaProducer {

  @Autowired
  @Qualifier("userKafkaTemplate")
  KafkaTemplate<String, String> userKafkaTemplate;

  @Override
  public void sendUserMesage(UserMessage userMessage) {
    userKafkaTemplate.send("USER_TOPIC", GsonUtils.toJson(userMessage))
        .addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

          @Override
          public void onSuccess(SendResult<String, String> result) {
            log.info("Kafka sent message='{}' with offset={}", GsonUtils.toJson(userMessage),
                result.getRecordMetadata().offset());
          }

          @Override
          public void onFailure(Throwable ex) {
            log.error("Kafka unable to send message='{}'", GsonUtils.toJson(userMessage), ex);
          }
        });
  }

}
