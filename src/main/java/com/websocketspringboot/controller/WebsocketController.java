package com.websocketspringboot.controller;

import java.time.LocalDateTime;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.websocketspringboot.modal.Message;
import com.websocketspringboot.modal.OutputMessage;

@Controller
public class WebsocketController {

    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public OutputMessage greeting(@Payload Message message) throws InterruptedException {
    	
        Thread.sleep(500); // simulated delay
        String time = LocalDateTime.now().toString();
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }
	
}