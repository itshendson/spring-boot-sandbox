package itshendson.springbootsandbox;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/")
    public String helloWorld() {
        return "<h1>Hello World!</h1>";
    }

    @GetMapping("/api")
    public String api() {
        return "This should be an API";
    }
}
