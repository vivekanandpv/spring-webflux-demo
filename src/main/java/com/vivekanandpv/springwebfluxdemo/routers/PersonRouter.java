package com.vivekanandpv.springwebfluxdemo.routers;

import com.vivekanandpv.springwebfluxdemo.handlers.PersonHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
//  This is the equivalent of a controller
//  It's job is to connect the path with a handler
public class PersonRouter {
    //  In the old approach, this handler can be method injected as well
    private final PersonHandler handler;

    public PersonRouter(PersonHandler handler) {
        this.handler = handler;
    }

    @Bean
    public RouterFunction<ServerResponse> getRouter() {
        return RouterFunctions
                .route(
                        GET("/api/v1/persons")  //  path must start with a slash '/'
                                .and(accept(MediaType.APPLICATION_JSON)),
                        handler::getPerson
//                        req -> handler.getPerson(req) //  verbose
                );
    }
}
