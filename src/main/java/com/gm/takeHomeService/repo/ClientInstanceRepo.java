package com.gm.takeHomeService.repo;

import com.gm.takeHomeService.model.ClientInstancePojo;
import com.gm.takeHomeService.model.CreateRequest;
import com.gm.takeHomeService.model.FindByClientRequest;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@Component
public class ClientInstanceRepo {

    private ArrayList<ClientInstancePojo> clientInstanceMap;

    public ClientInstanceRepo() {
        AtomicInteger index = new AtomicInteger();
        this.clientInstanceMap = new ArrayList<>();
        String fileName = "src/main/resources/mock/gmData.csv";

        try {
            List<ClientInstancePojo> csv = new CsvToBeanBuilder(new FileReader(fileName))
                    .withType(ClientInstancePojo.class)
                    .build()
                    .parse();

            csv.forEach(row -> {
                if (!(row.getDate() == "" || row.getClient() == "")) {
                    if (!(row.getDate().equals("Date"))) {
                        row.setId(Integer.toString(index.get()));
                        index.getAndIncrement();
                        clientInstanceMap.add(row);
                    }
                }
            });

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<ClientInstancePojo> getAllClientInstances() {
        ArrayList<ClientInstancePojo> clientInstancePojoList = new ArrayList<>();

        for (ClientInstancePojo entry : clientInstanceMap) {
            clientInstancePojoList.add(entry);
        }
        return clientInstancePojoList;
    }

    public ArrayList<ClientInstancePojo> findByClientName(String clientName) {
        ArrayList<ClientInstancePojo> clientInstancePojoList = new ArrayList<>();

        for (ClientInstancePojo entry : clientInstanceMap) {
            String requestedClientName = clientName.toLowerCase();
            String currentClientName = entry.getClient().toLowerCase();
            if (currentClientName.contains(requestedClientName)) {
                clientInstancePojoList.add(entry);
            }
        }
        return clientInstancePojoList;
    }

    public void addClientInstance(CreateRequest createRequest) {
        try {
            ClientInstancePojo requestClientInstance = createRequest.getClientInstance();
            requestClientInstance.setId(Integer.toString(clientInstanceMap.size()));
            clientInstanceMap.add(requestClientInstance);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
