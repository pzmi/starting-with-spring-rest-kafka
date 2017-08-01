package io.github.pzmi.startingwithspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
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
}
