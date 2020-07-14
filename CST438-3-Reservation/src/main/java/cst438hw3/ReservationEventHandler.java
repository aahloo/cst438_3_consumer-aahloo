package cst438hw3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "${queueName}")
public class ReservationEventHandler {	// event receiver class
	
	private static final Logger Log = LoggerFactory.getLogger(ReservationEventHandler.class);
	
	@RabbitHandler
	public void receive (String in) {
		
		System.out.println(in);
		Log.info(" [ReservationEventHandler] Received '" + in + "'");
		
	}
}
