package com.czp.mystrongpoint.controller;

import com.czp.mystrongpoint.model.Rouge;
import com.czp.mystrongpoint.service.RougeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/rouge")
public class RougeController {

    @Autowired
    private RougeService rougeService;

    @GetMapping(path = "/{id}")
    public Mono<Rouge> getRouge(@PathVariable(name="id") String rougeId) {
        return Mono.just(rougeService.getRouge(rougeId));
    }

}
