package io.codebyexample.kafkamultiplebrokers.core.usecase;

import io.codebyexample.kafkamultiplebrokers.core.entity.Greeting;

/**
 * @author huypva
 */
public interface GreetUseCase {

  Greeting greet(String name);
}
