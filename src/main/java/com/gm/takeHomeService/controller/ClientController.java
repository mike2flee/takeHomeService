package com.gm.takeHomeService.controller;

import com.gm.takeHomeService.model.ClientInstancePojo;
import com.gm.takeHomeService.model.FindByClientRequest;
import com.gm.takeHomeService.model.TimeSheetResponse;
import com.gm.takeHomeService.repo.ClientInstanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/timesheetApi")
public class ClientController {

    @Autowired
    ClientInstanceRepo clientInstanceRepo;

    @GetMapping("/getAll")
    public TimeSheetResponse getAll() {
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

    @PostMapping("/findByClient")
    public TimeSheetResponse findByClient(@RequestBody  FindByClientRequest findByClientRequest) {
        TimeSheetResponse response = new TimeSheetResponse();
        try {
            ArrayList<ClientInstancePojo> entityList = new ArrayList<>();
            entityList = clientInstanceRepo.findByClientName(findByClientRequest);
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
