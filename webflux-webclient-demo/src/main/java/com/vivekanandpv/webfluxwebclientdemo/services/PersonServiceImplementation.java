package com.vivekanandpv.webfluxwebclientdemo.services;

import com.vivekanandpv.webfluxwebclientdemo.viewmodels.PersonViewModel;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImplementation implements PersonService {
    private final WebClient webClient;

    public PersonServiceImplementation(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("http://localhost:8081/api/v1")
                .build();
    }

    @Override
    public Mono<PersonViewModel> getPerson() {
        return webClient
                .get()
                .uri("/persons")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PersonViewModel.class);
    }
}
