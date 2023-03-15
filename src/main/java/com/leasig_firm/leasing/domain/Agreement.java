package com.leasig_firm.leasing.domain;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@Table(name = "client_agreement")
public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ca_seq")
    @SequenceGenerator(name = "ca_seq", sequenceName = "client_agreement_id_seq", allocationSize = 1)
    private int id;
    @Column(name = "agreement")
    private int agreement;
    @Column(name = "term")
    private String term;
    @Column(name = "payment")
    private double payment;
    @Column(name = "debt")
    private double debt;
    @Column(name = "credit")
    private double credit;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_users", nullable = false)
    private User user;

    @JsonBackReference
    @OneToOne(mappedBy = "agreement")
    private CarInfo carInfo;
}
