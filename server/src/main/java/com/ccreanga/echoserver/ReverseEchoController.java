package com.ccreanga.echoserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReverseEchoController {

    private static final String DEFAULT_TEXT = "Hi - you might want to pass the text parameter :)";
    @RequestMapping(value="/")
    public String reverseEcho(
            @RequestParam(name = "text",required = false,defaultValue = DEFAULT_TEXT) String text) {

        return text.equals(DEFAULT_TEXT)? DEFAULT_TEXT :new StringBuilder(text).reverse().toString();
    }
}
