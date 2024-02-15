package com.example.restapi;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class Myroute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("timer:my-timer")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        String in = exchange.getMessage().getBody(String.class);
                        in="Hello world";
                        exchange.getMessage().setBody(in);
                        exchange.getMessage().setHeader("Name","Vikas");
                        System.out.println(exchange.getMessage().getHeaders());

                    }
                })

                .bean("mybean","getMessage(${header.Name})")
                .log("${body}");
    }


}
