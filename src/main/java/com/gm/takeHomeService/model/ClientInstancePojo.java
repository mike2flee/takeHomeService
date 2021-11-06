package com.gm.takeHomeService.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
@ToString
public class ClientInstancePojo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "Date")
    @CsvBindByPosition(position = 0)
    private String date;

    @Column(name = "Client")
    @CsvBindByPosition(position = 1)
    private String client;


    @Column(name = "Project")
    @CsvBindByPosition(position = 2)
    private String project;

    @Column(name = "Project Code")
    @CsvBindByPosition(position = 3)
    private String projectCode;

    @Column(name = "Hours")
    @CsvBindByPosition(position = 4)
    private String hours;

    @Column(name = "Billable?")
    @CsvBindByPosition(position = 5)
    private String isBillable;

    @Column(name = "First Name")
    @CsvBindByPosition(position = 6)
    private String firstName;

    @Column(name = "Last Name")
    @CsvBindByPosition(position = 7)
    private String lastName;

    @Column(name = "Billing Rate")
    @CsvBindByPosition(position = 8)
    private String billingRate;

}
