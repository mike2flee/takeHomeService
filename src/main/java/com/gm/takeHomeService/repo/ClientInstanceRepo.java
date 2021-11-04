package com.gm.takeHomeService.repo;

import com.gm.takeHomeService.model.ClientInstancePojo;
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
}
