package com.gm.takeHomeService.dao;

import com.gm.takeHomeService.model.ClientInstancePojo;

import java.util.ArrayList;

public interface ClientInstance {
    public ArrayList<ClientInstancePojo> getAllClientInstances();

    public ArrayList<ClientInstancePojo> findClientInstancesByClientId(String clientName);

    public void createClientInstance(ClientInstancePojo client);
}
