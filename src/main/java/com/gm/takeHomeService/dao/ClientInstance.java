package com.gm.takeHomeService.dao;

import com.gm.takeHomeService.model.ClientInstancePojo;
import java.util.List;

public interface ClientInstance {
    public List<ClientInstancePojo> getAllClientInstances();
    public List<ClientInstancePojo> findClientInstancesByClientId ( String clientName );
    public void createClientInstance (ClientInstancePojo client);
}
