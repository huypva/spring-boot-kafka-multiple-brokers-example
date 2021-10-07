package io.codebyexample.kafkamultiplebrokers.dataprovider.bankkafka;


import io.codebyexample.kafkamultiplebrokers.core.entity.BankMessage;

/**
 * @author huypva
 * */
public interface BankKafkaProducer {

  void sendBankMessage(BankMessage bankMessage);

}
