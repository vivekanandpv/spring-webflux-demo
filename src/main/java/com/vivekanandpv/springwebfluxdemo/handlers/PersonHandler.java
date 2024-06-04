package com.vivekanandpv.springwebfluxdemo.handlers;

import com.vivekanandpv.springwebfluxdemo.models.Person;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
//  This is like an even handler
//  Not called directly by the client,
//  but called by the router
public class PersonHandler {
    public Mono<ServerResponse> getPerson(ServerRequest request) {

        //  regular 3-tier architecture starts from this point
        //  Inject the service->repository here
        //  Everything has to be reactive now
        //  You may use BodyInserters.fromPublisher, etc for this
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(
                        new Person(
                                12,
                                "John",
                                "Doe",
                                "john@gmail.com"
                        )
                ));
    }
}
