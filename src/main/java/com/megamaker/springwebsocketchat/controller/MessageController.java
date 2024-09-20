package com.megamaker.springwebsocketchat.controller;

import com.megamaker.springwebsocketchat.message.Greeting;
import com.megamaker.springwebsocketchat.message.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greet(Message message) {
        return new Greeting("Welcome!! " + HtmlUtils.htmlEscape(message.getName()));
    }

}