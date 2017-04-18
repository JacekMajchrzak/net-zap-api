package com.netzap.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Survey {

    @Id
    private Long id;
    private String name;
    private String surname;
    private String address;

    public Survey(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }
}
