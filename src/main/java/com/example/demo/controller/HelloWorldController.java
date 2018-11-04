package com.example.demo.controller;

import com.example.demo.configuration.DemoProperties;
import com.example.demo.controller.api.MessageDTO;
import com.example.demo.controller.api.PayloadDTO;
import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/hello")
public class HelloWorldController {

    @Value("${demo-properties.hello-msg}")
    private String helloMessage;

    private final DemoProperties demoProperties;
    private final HelloService helloService;

    public HelloWorldController(DemoProperties demoProperties, HelloService helloService) {
        this.demoProperties = demoProperties;
        this.helloService = helloService;
    }

    @GetMapping
    public String getHello() {
        return helloMessage; //returns plain text instead of json
    }

    @GetMapping(value = "en")
    public MessageDTO getHelloEnglish() {
        return new MessageDTO(helloMessage);
    }

    @GetMapping(value = "sv")
    public MessageDTO getHelloSwedish() {
        return new MessageDTO(demoProperties.getHelloMsgSv());
    }

    @GetMapping(value = "{user}")
    public MessageDTO getHelloForUser(@PathVariable("user") String user,
                                      @RequestParam(value = "language", defaultValue = "en") String language) {
        return new MessageDTO(helloService.getHelloResponse(user, language));
    }

    @PostMapping
    public MessageDTO postHello(@Valid @RequestBody PayloadDTO payload) {
        return new MessageDTO(String.format("your payload was: %s", payload.getMessage()));
    }

    @GetMapping(value = "error")
    public void getError() {
        throw new IllegalArgumentException("Invalid input, please try again");
    }
}
