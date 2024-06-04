package com.vivekanandpv.webfluxwebclientdemo.handlers;

import com.vivekanandpv.webfluxwebclientdemo.services.PersonService;
import com.vivekanandpv.webfluxwebclientdemo.viewmodels.PersonViewModel;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class PersonClientHandler {
    private final PersonService personService;

    public PersonClientHandler(PersonService personService) {
        this.personService = personService;
    }

    public Mono<ServerResponse> getPerson(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        BodyInserters
                                .fromPublisher(
                                        personService.getPerson(),
                                        PersonViewModel.class
                                )
                );
    }
}
