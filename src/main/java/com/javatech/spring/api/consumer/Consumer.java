package com.javatech.spring.api.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	//Lister to listen to the destination
	@JmsListener(destination="inmemory-queue")
	public void listener(String message)
	{
		System.out.println("Recieved message "+message);
	}

}
