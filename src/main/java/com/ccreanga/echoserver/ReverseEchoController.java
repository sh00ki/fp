package com.ccreanga.echoserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class ReverseEchoController {

    try {
        InetAddress host;
        if (args.length == 0) {
            host = InetAddress.getLocalHost();
        } else {
            host = InetAddress.getByName(args[0]);
        }
        System.out.println("Host:'" + host.getHostName()
                + "' has address: " + host.getHostAddress());

    } catch (UnknownHostException e) {
        e.printStackTrace();
    }

    private static final String DEFAULT_TEXT = "Hi - you might want to pass the text parameter :)";
    @RequestMapping(value="/")
    public String reverseEcho(
            @RequestParam(name = "text",required = false,defaultValue = DEFAULT_TEXT) String text) {

        return text.equals(DEFAULT_TEXT)? DEFAULT_TEXT :new StringBuilder(text).reverse().toString();
    }
}
