package com.ralph.cammelproject.config;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
@Component()
public class MyRouter extends RouteBuilder  {
    @Override
    public void configure() throws Exception {

        //        from("timer:first-timer?period=10000").log("${body}").to("direct:remoteService");
//
//        from("direct:remoteService").log("start remote service ${body}").to("log:remoteService");
//
//        from("file:files/start_json")
//                .log("start ${body}")
//                .to("file:files/end_json");

        from("file:files")
                .log("start ${body}")
                .to("activemq:my-activemq-queue");
    }
}
