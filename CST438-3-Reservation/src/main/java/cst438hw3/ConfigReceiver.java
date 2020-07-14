package cst438hw3;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigReceiver {	// configuration class to configure message query and binds to city-reservation exchange (ConfigPublisher class)
	
	@Value("${queueName}")
	private String queueName;
	
	@Bean
	public FanoutExchange fanout() {
		return new FanoutExchange("city-reservation");
	}
	
	@Bean
	public Queue queue1() {
		return new Queue(queueName);
	}
	
	@Bean
	public Binding binding1(FanoutExchange fanout, Queue queue1) {
		return BindingBuilder.bind(queue1).to(fanout);
	}
	
	@Bean
	public ReservationEventHandler receiver() {
		return new ReservationEventHandler();
	}

}
