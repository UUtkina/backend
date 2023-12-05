package ait.de.shop_01_12.entyty;

import jakarta.persistence.*;


import java.math.BigDecimal;

@Entity


public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int quantity;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OOrder order;

}