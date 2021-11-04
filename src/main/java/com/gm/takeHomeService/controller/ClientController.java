package com.gm.takeHomeService.controller;

import com.gm.takeHomeService.repo.ClientInstanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientInstanceRepo clientInstanceRepo;

    @GetMapping("/getAllClientInstances")
    public ClientInstanceRepo index() {
        return  clientInstanceRepo;
    }
}
