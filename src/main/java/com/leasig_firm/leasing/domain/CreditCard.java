package com.leasig_firm.leasing.domain;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.persistence.*;

@Data
@ToString(exclude = {"users"})
@EqualsAndHashCode(exclude = {"users"})
@Entity
@Table(name = "credit_card")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cc_seq")
    @SequenceGenerator(name = "cc_seq", sequenceName = "credit_card_id_seq", allocationSize = 1)
    private int id;
    @Column(name = "card_number")
    private int cardNumber;
    @Column(name = "card_type")
    private String cardType;
    @Column(name = "expiration_date")
    private String expirationDate;
    @Column(name = "cvc_code")
    private int CVC;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_users", nullable = false)
    private User user;
}
