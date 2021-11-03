package com.gm.takeHomeService.jaxrs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
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
