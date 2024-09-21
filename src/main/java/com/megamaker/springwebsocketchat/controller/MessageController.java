package com.megamaker.springwebsocketchat.controller;

import com.megamaker.springwebsocketchat.message.Greeting;
import com.megamaker.springwebsocketchat.message.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
@RequiredArgsConstructor
public class MessageController {
    private final SimpMessagingTemplate messagingTemplate;

    // topic 사용
    @MessageMapping("/t/hello")
    @SendTo("/topic/greetings")
    public Greeting greet1(Message message) {
        return new Greeting("Welcome(Topic)!! " + HtmlUtils.htmlEscape(message.getName()));
    }

    // queue 사용
    @MessageMapping("/q/hello")
    public void greet2(Message message) {
        Greeting greeting = new Greeting("Welcome(Queue)!! " + HtmlUtils.htmlEscape(message.getName()));
        messagingTemplate.convertAndSend("/queue/greetings/1", greeting);
    }
}