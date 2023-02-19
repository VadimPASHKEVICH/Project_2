package com.leasing.entity;
import lombok.Data;

@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String login;
    private String password;
    private String agreement;
}
