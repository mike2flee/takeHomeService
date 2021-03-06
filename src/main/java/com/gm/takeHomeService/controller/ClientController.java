package com.gm.takeHomeService.controller;

import com.gm.takeHomeService.model.ClientInstancePojo;
import com.gm.takeHomeService.model.CreateRequest;
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

    @CrossOrigin(origins = "*")
    @GetMapping("/getAll")
    public TimeSheetResponse getAll() {
        TimeSheetResponse response = new TimeSheetResponse();
        try {
            ArrayList<ClientInstancePojo> entityList = new ArrayList<>();
            entityList = clientInstanceRepo.getAllClientInstances();
            if (!entityList.isEmpty()) {
                response.setStatusCode(200);
                response.setStatusMessage("Success");
                response.setClientInstancePojoList(entityList);
            } else {
                response.setStatusCode(404);
                response.setStatusMessage("No Data Found");
            }
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/findByClient")
    public TimeSheetResponse findByClient(@RequestParam("clientName") String clientName) {
        TimeSheetResponse response = new TimeSheetResponse();
        try {
            ArrayList<ClientInstancePojo> entityList = new ArrayList<>();
            entityList = clientInstanceRepo.findByClientName(clientName);
            if (!entityList.isEmpty()) {
                response.setStatusCode(200);
                response.setStatusMessage("Success");
                response.setClientInstancePojoList(entityList);
            } else {
                response.setStatusCode(404);
                response.setStatusMessage("No Data Found");
            }
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/create")
    public TimeSheetResponse createNewInstance(@RequestBody CreateRequest createRequest) {
        TimeSheetResponse response = new TimeSheetResponse();
        try {
            clientInstanceRepo.addClientInstance(createRequest);
            response.setStatusCode(200);
            response.setStatusMessage("Success");
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }
}
