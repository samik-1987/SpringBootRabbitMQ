package com.example.demo.registration;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MsgRegistrationSource {

	@Output("msgRegistrationChannel")
	MessageChannel msgRegistration();

}
