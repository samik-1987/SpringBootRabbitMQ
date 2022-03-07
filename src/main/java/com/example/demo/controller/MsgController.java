package com.example.demo.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CustomMessage;
import com.example.demo.config.*;

@RestController
@RequestMapping("/msg")
public class MsgController {
	
	@Autowired
	AmqpTemplate template;

	@PostMapping("/publish")
	public String publishMsg(@RequestBody CustomMessage msg)
	{
		try
		{
			msg.setMsgId(UUID.randomUUID().toString());
			msg.setMsgDate(new Date().toString());
			msg.setMsgStatus("Published");
			template.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.ROUTING_KEY, msg);
			System.out.println(msg);
		
		}
		catch (Exception e) {
			String error = e.getMessage();
		}
		
		return "Message Published";
	}
}