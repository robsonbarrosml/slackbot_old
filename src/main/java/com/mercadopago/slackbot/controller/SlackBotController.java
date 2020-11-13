package com.mercadopago.slackbot.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadopago.slackbot.model.Payment;
import com.mercadopago.slackbot.service.SlackBotService;

import lombok.Getter;
import me.ramswaroop.jbot.core.slack.Bot;
import me.ramswaroop.jbot.core.slack.Controller;
import me.ramswaroop.jbot.core.slack.EventType;
import me.ramswaroop.jbot.core.slack.models.Event;
import me.ramswaroop.jbot.core.slack.models.Message;


/**
 *
 * @author 
 */
@Component
@Getter
public class SlackBotController extends Bot {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(SlackBotController.class);

    @Autowired
    ObjectMapper mapper = new ObjectMapper();
    
    @Autowired
    SlackBotService slackBotService = new SlackBotService();
    
    @Value("${slackBotToken}")
    private String slackToken;

    @Override
    public Bot getSlackBot() {
        return this;
    }
    
    
    @Controller(events = {EventType.DIRECT_MENTION})
    public void commandPay(WebSocketSession session, Event event) {
    	System.out.println(slackBotService.setCommand(event));
    	if (!slackBotService.setCommand(event).equals("stopConversation")) {
    		startConversation(event, slackBotService.setCommand(event));
    	}  
        reply(session, event, new Message(slackBotService.sendResponse(slackBotService.setCommand(event))));
    }
    
    @Controller
    public void findPay(WebSocketSession session, Event event) throws JsonProcessingException {
    	try {
    		/* Verifica se uma conversa já foi iniciada */
    		if (isConversationOn(event)) {
    			Payment returnedPayment = slackBotService.returnedPayment(event);
                reply(session, event, new Message(returnedPayment.toString()));
    		}
    	} catch (Exception e) {
    		reply(session, event, new Message("Pagamento inválido, informe o comando novamente."));
		}
    	stopConversation(event);
    }    
}
