package com.gaber.kafkatest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    @PostMapping("/{message}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @WriteOperation
    public String monitor(@PathVariable("message") String message){
        return message;
    }
}
