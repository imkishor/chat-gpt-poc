package com.kishore.anand.chatgpt.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatGptRequest {

    public String model;
    public List<Message> messages;

    public int temperature;

    public int max_tokens;

    public  int top_p;

    public int frequency_penalty;

    public  int presence_penalty;

    public ChatGptRequest(String model, String prompt, int temperature,int maxTokens,int topP,int frequencyPenalty, int presencePenalty) {
        this.model = model;
        this.messages = new ArrayList<>();
        messages.add(new Message("user", prompt));
        this.temperature = temperature;
        this.max_tokens=maxTokens;
        this.top_p=topP;
        this.frequency_penalty=frequencyPenalty;
        this.presence_penalty= presencePenalty;
    }
}
