package com.example.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.demo.config.RabbitConfig;
import com.example.demo.entity.CustomMessage;

@Component
public class MsgConsumer {
	
//	@RabbitListener(queues = RabbitConfig.QUEUE)
//	public void listener(CustomMessage customMessage)
//	{
//		customMessage.setMsgStatus("Consumed");
//		System.out.println(customMessage);
//	}

}
