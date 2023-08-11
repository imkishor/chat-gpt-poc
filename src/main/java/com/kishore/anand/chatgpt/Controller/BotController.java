package com.kishore.anand.chatgpt.Controller;


import com.kishore.anand.chatgpt.dtos.ChatGptReponse;
import com.kishore.anand.chatgpt.dtos.ChatGptRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/bot")
public class BotController {

    @Value("${openapi.model}")
    public String model;

    @Value("${openapi.post.url}")
    public String apiURL;

    @Value("${openapi.temperature}")
    public int temperature;

    @Value("${openapi.max_tokens}")
    public int maxTokens;

    @Value("${openapi.top_p}")
    public int topP;

    @Value("${openapi.frequency_penalty}")
    public int frequencyPenalty;

    @Value("${openapi.presence_penalty}")
    public int presencePenalty;

    @Autowired
    public RestTemplate restTemplate;

    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt) {
        ChatGptRequest request = new ChatGptRequest(model, prompt,temperature,maxTokens,topP,frequencyPenalty,presencePenalty);
        ChatGptReponse reponse = restTemplate.postForObject(apiURL, request, ChatGptReponse.class);
        return reponse.getChoices().get(0).getMessage().getContent();
    }


}
