package com.gm.takeHomeService.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientInstancePojo {
    private String id;
    private String date;
    private String client;
    private String projectCode;
    private Integer hours;
    private Boolean isBillable;
    private String firstName;
    private String lastName;
    private Integer billingRate;

}
