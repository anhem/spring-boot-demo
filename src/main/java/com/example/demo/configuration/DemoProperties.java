package com.example.demo.configuration;

import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
@Configuration
@ConfigurationProperties("demo-properties")
public class DemoProperties {

    @NotNull
    @Length(min = 1)
    private String helloMsg;
    @NotNull
    @Length(min = 1)
    private String helloMsgSv;
    @NotNull
    @Length(min = 1)
    private String jsonPlaceholderBaseUrl;

    public String getHelloMsg() {
        return helloMsg;
    }

    public void setHelloMsg(String helloMsg) {
        this.helloMsg = helloMsg;
    }

    public String getHelloMsgSv() {
        return helloMsgSv;
    }

    public String getJsonPlaceholderBaseUrl() {
        return jsonPlaceholderBaseUrl;
    }

    public void setJsonPlaceholderBaseUrl(String jsonPlaceholderBaseUrl) {
        this.jsonPlaceholderBaseUrl = jsonPlaceholderBaseUrl;
    }

    public void setHelloMsgSv(String helloMsgSv) {
        this.helloMsgSv = helloMsgSv;
    }
}
