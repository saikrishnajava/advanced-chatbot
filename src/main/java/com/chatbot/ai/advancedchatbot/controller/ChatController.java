package com.chatbot.ai.advancedchatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.ai.advancedchatbot.constant.ChatbotConstants;
import com.chatbot.ai.advancedchatbot.nlp.NLPService;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@RestController
public class ChatController {

    @Autowired
    private NLPService nlpService;
    private static Logger logger = LogManager.getLogger(ChatController.class);

    @PostMapping("/chat")
    public String chat(@RequestBody String message) {
        // Analyze sentiment
        String sentiment = nlpService.analyzeSentiment(message);
        logger.info("sentiment for message is:"+sentiment);
        // Respond based on sentiment
        if (ChatbotConstants.POSITIVE.equalsIgnoreCase(sentiment)) {
            return ChatbotConstants.POSITIVE_RESPONSE;
        } else if (ChatbotConstants.NEGATIVE.equalsIgnoreCase(sentiment)) {
            return ChatbotConstants.NEGATIVE_RESPONSE;
        } else {
            return ChatbotConstants.NEUTRAL_RESPONSE;
        }
    }
}

