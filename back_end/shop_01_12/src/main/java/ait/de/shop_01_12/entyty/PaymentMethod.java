package ait.de.shop_01_12.entyty;

import jakarta.persistence.*;

import java.util.List;



@Entity

public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String method;

    @OneToMany(mappedBy = "paymentMethod")
    private List<OOrder> orders;
}