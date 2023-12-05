package ait.de.shop_01_12.entyty;
import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
public class ProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private BigDecimal price;
    private int quantity;

}