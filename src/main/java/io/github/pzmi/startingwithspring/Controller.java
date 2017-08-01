package io.github.pzmi.startingwithspring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
@Slf4j
public class Controller {
    private String name = "everybody";

    @GetMapping
    public String greet() {
        return "Hello " + name;
    }

    @GetMapping("/{name}")
    public GreetingName greetWithName(@PathVariable String name) {
        return new GreetingName(name);
    }

    @StreamListener(Sink.INPUT)
    public void onMessage(String name) {
        log.info("Received name: {}", name);
        this.name = name;
    }
}
