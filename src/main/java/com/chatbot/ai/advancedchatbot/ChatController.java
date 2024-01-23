package com.chatbot.ai.advancedchatbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    private NLPService nlpService;

    @PostMapping("/chat")
    public String chat(@RequestBody String message) {
        // Analyze sentiment
        String sentiment = nlpService.analyzeSentiment(message);

        // Respond based on sentiment
        if ("positive".equals(sentiment)) {
            return "That's great! I'm glad to hear that.";
        } else if ("negative".equals(sentiment)) {
            return "I'm sorry to hear that. How can I assist you?";
        } else {
            return "Thanks for sharing! If you have any questions, feel free to ask.";
        }
    }
}

