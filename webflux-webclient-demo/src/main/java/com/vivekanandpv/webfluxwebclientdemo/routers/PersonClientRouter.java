package com.vivekanandpv.webfluxwebclientdemo.routers;

import com.vivekanandpv.webfluxwebclientdemo.handlers.PersonClientHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class PersonClientRouter {
    private final PersonClientHandler personClientHandler;

    public PersonClientRouter(PersonClientHandler personClientHandler) {
        this.personClientHandler = personClientHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> getPersonClientHandler() {
        return RouterFunctions
                .route(
                        GET("/api/v1/resource")
                                .and(accept(MediaType.APPLICATION_JSON)),
                        personClientHandler::getPerson
                );
    }
}
