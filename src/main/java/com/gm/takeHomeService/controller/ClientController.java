package com.gm.takeHomeService.controller;

import com.gm.takeHomeService.model.ClientInstancePojo;
import com.gm.takeHomeService.model.TimeSheetResponse;
import com.gm.takeHomeService.repo.ClientInstanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientInstanceRepo clientInstanceRepo;

    @GetMapping("/getAllClientInstances")
    public TimeSheetResponse index() {
        TimeSheetResponse response = new TimeSheetResponse();
        try {
            ArrayList<ClientInstancePojo> entityList = new ArrayList<>();
            entityList = clientInstanceRepo.getAllClientInstances();
            if (!entityList.isEmpty()) {
                response.setStatusCode("200");
                response.setStatusMessage("Success");
                response.setClientInstancePojoList(entityList);
            } else {
                response.setStatusCode("404");
                response.setStatusMessage("No Data Found");
            }
        } catch (Exception e) {
            response.setStatusCode("500");
            response.setStatusMessage(e.getMessage());
        }

        return response;
    }
}
