package io.codebyexample.kafkamultiplebrokers.core.usecase.bank;


import io.codebyexample.kafkamultiplebrokers.core.entity.BankMessage;

/**
 * @author huypva
 * */
public interface BankUseCase {

  void banking(int bankId);

  void processBanking(BankMessage bankMessage);
}
