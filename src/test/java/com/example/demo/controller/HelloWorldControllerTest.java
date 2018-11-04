package com.example.demo.controller;

import com.example.demo.controller.api.MessageDTO;
import com.example.demo.controller.api.PayloadDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static com.example.demo.service.HelloService.HELLO_EN;
import static com.example.demo.service.HelloService.HELLO_SV;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloWorldControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getHelloEnglishReturnsHelloMsg() {
        MessageDTO messageDTO = testRestTemplate.getForObject("/api/hello/en", MessageDTO.class);

        assertNotNull(messageDTO);
        assertEquals("Hello world!", messageDTO.getMessage());
    }

    @Test
    public void getHelloSwedishReturnsHelloMsg() {
        MessageDTO messageDTO = testRestTemplate.getForObject("/api/hello/sv", MessageDTO.class);

        assertNotNull(messageDTO);
        assertEquals("Hej världen!", messageDTO.getMessage());
    }

    @Test
    public void getHelloForUserReturnsHelloMsg() {
        String user = "test-user";
        MessageDTO defaultMessageDTO = testRestTemplate.getForObject(String.format("/api/hello/%s", user), MessageDTO.class);

        assertNotNull(defaultMessageDTO);
        assertEquals(String.format(HELLO_EN, user), defaultMessageDTO.getMessage());

        MessageDTO swedishMessageDTO = testRestTemplate.getForObject(String.format("/api/hello/%s?language=%s", user, "sv"), MessageDTO.class);

        assertNotNull(swedishMessageDTO);
        assertEquals(String.format(HELLO_SV, user), swedishMessageDTO.getMessage());
    }

    @Test
    public void postHelloReturnsValidationError() {
        ResponseEntity<Map> response = testRestTemplate.postForEntity("/api/hello", new PayloadDTO(), Map.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void postHelloReturnsMsg() {
        PayloadDTO payload = new PayloadDTO("payload");
        MessageDTO messageDTO = testRestTemplate.postForObject("/api/hello", payload, MessageDTO.class);

        assertNotNull(messageDTO);
        assertTrue(messageDTO.getMessage().contains(payload.getMessage()));
    }

}