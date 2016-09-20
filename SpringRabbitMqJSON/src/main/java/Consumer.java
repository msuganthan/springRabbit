package main.java;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.SimpleMessageConverter;

public class Consumer implements MessageListener{

	@Override
    public void onMessage(Message message) {
		try {
			CustomMessage customMessage = retrieveCustomMessage(message);
	        System.out.println("customMessage"+customMessage);
		} catch(Exception e) {
			System.out.println("Exception raises");
		}
        
    }
	
	private CustomMessage retrieveCustomMessage(Message message) throws MessageConversionException{
		return (CustomMessage) new SimpleMessageConverter().fromMessage(message);
	}
	
}
