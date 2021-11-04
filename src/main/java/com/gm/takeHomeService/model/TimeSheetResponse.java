package com.gm.takeHomeService.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
public class TimeSheetResponse {
    private Integer statusCode;
    private String statusMessage;
    private ArrayList<ClientInstancePojo> clientInstancePojoList;

}
