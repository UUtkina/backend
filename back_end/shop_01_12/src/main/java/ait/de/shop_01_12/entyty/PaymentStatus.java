package ait.de.shop_01_12.entyty;

import jakarta.persistence.*;

import java.util.List;


@Entity

public class PaymentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String status;
    @OneToMany(mappedBy = "paymentStatus")
    private List<OOrder> orders;
}