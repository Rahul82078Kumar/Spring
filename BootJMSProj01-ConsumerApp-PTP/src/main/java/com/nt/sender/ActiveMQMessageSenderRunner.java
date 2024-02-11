package com.nt.sender;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;

@Component
public class ActiveMQMessageSenderRunner implements CommandLineRunner {

	@Autowired
	private JmsTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		/*	
		template.send("testmq1", new MessageCreator(){

			
			//using anonymous inner class logic
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message message = session.createTextMessage("From sender at ::  "+new Date());
				return message;
			}
			
		});
		*/
			
		//using lambda style Anonymous inner class
		
		template.send("testmq1", session->{
			return session.createTextMessage("From Sender at  "+new Date());
		});
				

	}

}
