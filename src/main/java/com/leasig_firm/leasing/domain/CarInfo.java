package com.leasig_firm.leasing.domain;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.persistence.*;

@Data
@ToString(exclude = {"client_agreement"})
@EqualsAndHashCode(exclude = {"client_agreement"})
@Entity
@Table(name = "car_info")
public class CarInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ci_seq")
    @SequenceGenerator(name = "ci_seq", sequenceName = "car_info_id_seq", allocationSize = 1)
    private int id;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "year_of_issue")
    private int yearOfIssue;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name = "id_agreement")
    private Agreement agreement;

}
