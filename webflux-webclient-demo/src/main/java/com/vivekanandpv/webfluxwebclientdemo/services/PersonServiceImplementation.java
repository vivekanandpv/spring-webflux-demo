package com.vivekanandpv.webfluxwebclientdemo.services;

import com.vivekanandpv.webfluxwebclientdemo.viewmodels.PersonViewModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImplementation implements PersonService {
    private final WebClient webClient;
    private final Logger logger;

    public PersonServiceImplementation(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("http://localhost:8081/api/v1")
                .build();
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public Mono<PersonViewModel> getPerson() {
        return webClient
                .get()
                .uri("/persons")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PersonViewModel.class)
                .doOnNext(p -> logger.info(p.toString()));  //  equivalent of peek (or tap in RxJS)
    }
}
