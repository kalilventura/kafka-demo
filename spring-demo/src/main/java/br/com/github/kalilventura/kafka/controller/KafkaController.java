package br.com.github.kalilventura.kafka.controller;

import br.com.github.kalilventura.kafka.model.User;
import br.com.github.kalilventura.kafka.service.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
@RequiredArgsConstructor
public class KafkaController {
    private final Producer producer;

    @PostMapping
    public void sendMessageToKafkaTopic(@RequestBody User user) {
        String message = String.format("User - name: %s | age: %s created =)", user.getName(), user.getAge());
        this.producer.sendMessage(message);
    }
}