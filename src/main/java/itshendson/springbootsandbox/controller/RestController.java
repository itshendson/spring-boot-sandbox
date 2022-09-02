package itshendson.springbootsandbox.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    // Pull **value** from application properties
    @Value("${welcome.message}")
    private String greeting;

    @GetMapping("/")
    public String helloWorld() {
        return greeting;
    }

    @GetMapping("/api")
    public String api() {
        return "This should be an API";
    }
}
