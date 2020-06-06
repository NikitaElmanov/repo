package ru.xml.common.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
}
