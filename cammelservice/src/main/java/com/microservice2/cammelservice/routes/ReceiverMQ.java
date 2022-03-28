package com.microservice2.cammelservice.routes;


import com.microservice2.cammelservice.model.Currency;
import com.microservice2.cammelservice.port.CurrencyExchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ReceiverMQ extends RouteBuilder {

    @Autowired
    @Qualifier("usa")
    CurrencyExchange currencyExchangeTransformations;

    @Override
    public void configure() throws Exception {
        from("activemq:my-activemq-queue")
                .log("${body}")
                .unmarshal().json(JsonLibrary.Jackson, Currency.class)
                .bean(currencyExchangeTransformations).log("${body}")
                .to("log:received-message-from-active-mq");

    }
}
