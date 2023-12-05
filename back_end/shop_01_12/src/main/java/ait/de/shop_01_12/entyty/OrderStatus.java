package ait.de.shop_01_12.entyty;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String status;
    @OneToMany(mappedBy = "orderStatus")
    private List<OOrder> orders;

}