package io.codebyexample.kafkamultiplebrokers.core.usecase.user;


import io.codebyexample.kafkamultiplebrokers.core.entity.UserMessage;

/**
 * @author huypva
 * */
public interface UserUseCase {

  void greet(UserMessage user);

  void goodbye(UserMessage user);
}
