package com.vivekanandpv.webfluxwebclientdemo.services;

import com.vivekanandpv.webfluxwebclientdemo.viewmodels.PersonViewModel;
import reactor.core.publisher.Mono;

public interface PersonService {
    Mono<PersonViewModel> getPerson();
}
