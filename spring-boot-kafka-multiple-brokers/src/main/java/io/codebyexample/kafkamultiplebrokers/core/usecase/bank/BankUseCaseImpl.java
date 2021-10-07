package io.codebyexample.kafkamultiplebrokers.core.usecase.bank;


import io.codebyexample.kafkamultiplebrokers.core.entity.BankMessage;
import io.codebyexample.kafkamultiplebrokers.dataprovider.bankkafka.BankKafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huypva
 * */
@Slf4j
@Component
public class BankUseCaseImpl implements BankUseCase {

  @Autowired
  BankKafkaProducer bankKafkaProducer;

  @Override
  public void banking(int bankId) {
    bankKafkaProducer.sendBankMessage(new BankMessage(bankId));
  }

  @Override
  public void processBanking(BankMessage bankMessage) {
    log.info("Process banking {} ", bankMessage.getBankId());
  }

}
