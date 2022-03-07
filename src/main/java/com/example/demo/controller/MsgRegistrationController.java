package com.example.demo.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CustomMessage;
import com.example.demo.registration.MsgRegistrationSource;


@RestController
@EnableBinding(MsgRegistrationSource.class)
public class MsgRegistrationController {

	@Autowired
	MsgRegistrationSource msgRegistrationSource;

	@RequestMapping("/register")
	@ResponseBody
	public String msgRegister(@RequestBody CustomMessage msg) {
		msg.setMsgId(UUID.randomUUID().toString());
		msg.setMsgDate(new Date().toString());
		msg.setMsgStatus("Published");
		msgRegistrationSource.msgRegistration().send(MessageBuilder.withPayload(msg).build());
		System.out.println(msg.toString());
		return "Message Registered";
	}
}
  
