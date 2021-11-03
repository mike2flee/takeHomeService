package com.gm.takeHomeService.dao.impl;

import com.gm.takeHomeService.dao.ClientInstance;
import com.gm.takeHomeService.model.ClientInstancePojo;

import java.util.List;

public class ClientInstanceImpl implements ClientInstance {
    @Override
    public List<ClientInstancePojo> getAllClientInstances() {
        return null;
    }

    @Override
    public List<ClientInstancePojo> findClientInstancesByClientId(String clientName) {
        return null;
    }

    @Override
    public void createClientInstance(ClientInstancePojo client) {

    }
}
