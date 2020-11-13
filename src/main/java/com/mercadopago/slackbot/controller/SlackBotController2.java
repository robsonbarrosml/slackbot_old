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
public class SlackBotController2 extends Bot {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(SlackBotController2.class);

    @Autowired
    ObjectMapper mapper = new ObjectMapper();
    
    @Value("${slackBotToken}")
    private String slackToken;

    @Override
    public Bot getSlackBot() {
        return this;
    }
//
//    @Controller(events = {EventType.DIRECT_MENTION, EventType.MESSAGE}, pattern = "pay", next = "findPay")
//    public void commandPay(WebSocketSession session, Event event) {
//        startConversation(event, "findPay");      
//        reply(session, event, new Message("Informe o número do pagamento"));
//    }
//    
//    
//    
//    @Controller
//    public void findPay(WebSocketSession session, Event event) throws JsonProcessingException {
//    	String uri = "http://api.mp.internal.ml.com/v1/payments/";
////    	String params = "?attributes=id, payer,status,status_detail,operation_type";
//    	String payment = event.getText().substring(event.getText().indexOf(" ") + 1, event.getText().length());
//    	//10174126009
//    	
//    	RestTemplate restTemplate = new RestTemplate();
//        
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.set("X-Caller-Scopes", "admin");
//     
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//        
//        ResponseEntity<JsonNode> result = restTemplate.exchange(uri + payment /*+ params*/, HttpMethod.GET, entity, JsonNode.class);
//        JsonNode responsePayload = result.getBody(); 
//        
//        Payment returnedPayment = mapper.treeToValue(responsePayload, Payment.class);
//
//        System.out.println(result);
//        reply(session, event, new Message(returnedPayment.toString()));
//        stopConversation(event);
//    }
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    @Controller(events = {EventType.DIRECT_MENTION, EventType.MESSAGE}, pattern = "teste")
//    public void test(WebSocketSession session, Event event) {
//    	String payment = event.getText();
//    	System.out.println(payment.substring(payment.indexOf(" ") + 1, payment.length()));
//        reply(session, event, new Message("Hi, I am " + slackService.getCurrentUser().getName() + " - " + event.getText()));
//    }
//    
//    
//    @Controller(events = {EventType.DIRECT_MENTION, EventType.DIRECT_MESSAGE})
//    public void onReceiveDM(WebSocketSession session, Event event) {
//        reply(session, event, new Message("Hi, I am " + slackService.getCurrentUser().getName()));
//    }
//    
//    
    
    
}
