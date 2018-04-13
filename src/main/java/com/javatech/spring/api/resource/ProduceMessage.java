package com.javatech.spring.api.resource;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/publish")
public class ProduceMessage {
	@Autowired
	JmsTemplate jmsTemplate;
	@Autowired
	private Queue queue;

	@RequestMapping("{message}")
	public String sendMessage(@PathVariable("message") String message) {
		jmsTemplate.convertAndSend(queue, message);
		return "Message published successfully";
	}

}
