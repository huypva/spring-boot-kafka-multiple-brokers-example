package io.codebyexample.kafkamultiplebrokers;

import io.codebyexample.kafkamultiplebrokers.configuration.properties.BankKafkaProperties;
import io.codebyexample.kafkamultiplebrokers.configuration.properties.UserKafkaProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * @author huypva
 * */
@EnableKafka
@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
public class KafkaMultipleBrokersApplication {

	@Autowired
	UserKafkaProperties userKafkaProperties;

	@Autowired
	BankKafkaProperties bankKafkaProperties;

	@EventListener(ApplicationReadyEvent.class)
	protected void readyProcess() {
		System.out.println("UserKafkaProperties: " + userKafkaProperties.getBootstrapServers());

		System.out.println("BankKafkaProperties: " + bankKafkaProperties.getBootstrapServers());
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaMultipleBrokersApplication.class, args);
	}

}
