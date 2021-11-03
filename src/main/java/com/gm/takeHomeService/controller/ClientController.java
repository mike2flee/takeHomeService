package com.gm.takeHomeService.controller;

import com.gm.takeHomeService.model.ClientInstancePojo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClientController {

    @GetMapping("/getAllClientInstances")
    public ClientInstancePojo index() {
        ClientInstancePojo client = new ClientInstancePojo();
        client.setClient("d");
        return  client;
    }
}
