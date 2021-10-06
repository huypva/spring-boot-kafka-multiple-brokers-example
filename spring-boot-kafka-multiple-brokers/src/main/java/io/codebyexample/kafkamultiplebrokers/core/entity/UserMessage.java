package io.codebyexample.kafkamultiplebrokers.core.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author huypva
 * */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserMessage {

  @SerializedName("user_id")
  long userId;
  @SerializedName("message")
  String message;
}
