package io.codebyexample.kafkamultiplebrokers.dataprovider.userkafka;


import io.codebyexample.kafkamultiplebrokers.core.entity.UserMessage;

/**
 * @author huypva
 * */
public interface UserKafkaProducer {

  void sendUserMesage(UserMessage bank);

}
