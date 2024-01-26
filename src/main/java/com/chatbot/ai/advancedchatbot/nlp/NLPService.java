package com.chatbot.ai.advancedchatbot.nlp;

import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;
import org.springframework.stereotype.Service;

@Service
public class NLPService {

    public String analyzeSentiment(String message) {
        Document doc = new Document(message);
        Sentence firstSentence = doc.sentences().get(0);
        return firstSentence.sentiment().toString();
    }
}



