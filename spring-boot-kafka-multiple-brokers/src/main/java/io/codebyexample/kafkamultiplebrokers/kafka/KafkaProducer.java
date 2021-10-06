package io.codebyexample.kafkamultiplebrokers.kafka;


import io.codebyexample.springbootkafka.core.entity.UserMessage;

/**
 * @author huypva
 * */
public interface KafkaProducer {

  void sendUserMesage(UserMessage bank);

}
