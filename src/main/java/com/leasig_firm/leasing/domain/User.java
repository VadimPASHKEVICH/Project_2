package com.leasig_firm.leasing.domain;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@ToString(exclude = {"client_agreement", "credit_card"})
@EqualsAndHashCode(exclude = {"client_agreement", "credit_card"})
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "u_seq")
    @SequenceGenerator(name = "u_seq", sequenceName = "user_id_seq", allocationSize = 1)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private int age;
    @Column(name = "user_login")
    private String login;
    @Column(name = "user_password")
    private String password;
    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "users")
    Collection<ClientAgreement> clientAgreements;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "users")
    Collection<CreditCard> creditCards;

}
