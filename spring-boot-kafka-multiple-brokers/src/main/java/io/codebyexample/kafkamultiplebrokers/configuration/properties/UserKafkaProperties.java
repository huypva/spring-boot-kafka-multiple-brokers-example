package io.codebyexample.kafkamultiplebrokers.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author huypva
 */
@ToString
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "user-kafka")
public class UserKafkaProperties extends KafkaProperties {

}
