package io.github.pzmi.startingwithspring;

import lombok.Value;

@Value
class GreetingName {
    private String greeting = "Hello";
    private final String name;
}
