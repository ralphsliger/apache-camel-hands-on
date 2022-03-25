package com.microservice2.cammelservice.config;


import com.microservice2.cammelservice.Currency;
import com.microservice2.cammelservice.CurrencyExchangeTransformations;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver extends RouteBuilder {

    @Autowired
    CurrencyExchangeTransformations currencyExchangeTransformations;

    @Override
    public void configure() throws Exception {
        from("activemq:my-activemq-queue")
                .log("${body}")
                .unmarshal().json(JsonLibrary.Jackson, Currency.class)
                .bean(currencyExchangeTransformations).log("${body}")
                .to("log:received-message-from-active-mq");

    }
}
