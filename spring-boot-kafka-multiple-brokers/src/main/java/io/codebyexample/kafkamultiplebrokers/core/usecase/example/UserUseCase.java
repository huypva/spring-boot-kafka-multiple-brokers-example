package io.codebyexample.kafkamultiplebrokers.core.usecase.example;

import io.codebyexample.springbootkafka.core.entity.UserMessage;

/**
 * @author huypva
 * */
public interface UserUseCase {

  void greet(UserMessage user);

  void goodbye(UserMessage user);
}
