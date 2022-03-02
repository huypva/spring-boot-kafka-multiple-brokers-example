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
@Configuration
@ConfigurationProperties(prefix = "bank-kafka")
public class BankKafkaProperties extends KafkaProperties {

}
