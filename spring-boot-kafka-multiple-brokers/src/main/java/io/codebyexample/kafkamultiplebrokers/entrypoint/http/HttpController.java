package io.codebyexample.kafkamultiplebrokers.entrypoint.http;

import io.codebyexample.springbootkafka.core.entity.UserMessage;
import io.codebyexample.springbootkafka.core.usecase.example.UserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huypva
 * */
@RestController
public class HttpController {

  @Autowired
  private UserUseCase userUseCase;

  @PostMapping(value = "/greet/{userId}")
  public void greet(@PathVariable("userId") long userId,
                    @RequestBody Message message) {
    UserMessage user = UserMessage.builder()
        .userId(userId)
        .message(message.getMessage())
        .build();
    userUseCase.greet(user);
  }

}
