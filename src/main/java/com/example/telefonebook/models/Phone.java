package com.example.telefonebook.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@ToString(exclude = "contact")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String number;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    Contact contact;

    public Phone(String number, Contact contact) {
        this.number = number;
        this.contact = contact;
    }

    public Phone(String number) {
        this.number = number;
    }

    public Phone() {
    }
}
