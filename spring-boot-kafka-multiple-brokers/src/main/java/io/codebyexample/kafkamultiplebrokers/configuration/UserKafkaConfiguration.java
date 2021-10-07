package io.codebyexample.kafkamultiplebrokers.configuration;

import io.codebyexample.kafkamultiplebrokers.configuration.properties.UserKafkaProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Component;

/**
 * @author huypva
 */
@Getter
@Setter
@Component
public class UserKafkaConfiguration {

  @Autowired
  UserKafkaProperties properties;

  //Producer
  @Bean("userKafkaTemplate")
  public KafkaTemplate<?, ?> kafkaTemplate() {
    KafkaTemplate<Object, Object> kafkaTemplate = new KafkaTemplate(kafkaProducerFactory());
    kafkaTemplate.setDefaultTopic(this.properties.getTemplate().getDefaultTopic());
    return kafkaTemplate;
  }

  public ProducerFactory<?, ?> kafkaProducerFactory() {
    DefaultKafkaProducerFactory<?, ?> factory = new DefaultKafkaProducerFactory(this.properties.buildProducerProperties());
    String transactionIdPrefix = this.properties.getProducer().getTransactionIdPrefix();
    if (transactionIdPrefix != null) {
      factory.setTransactionIdPrefix(transactionIdPrefix);
    }

    return factory;
  }

  //Consumer
  @Bean("userKafkaListenerContainerFactory")
  ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory();
    factory.setConsumerFactory(kafkaConsumerFactory());
    return factory;
  }

  public ConsumerFactory<Object, Object> kafkaConsumerFactory() {
    return new DefaultKafkaConsumerFactory(this.properties.buildConsumerProperties());
  }

}
