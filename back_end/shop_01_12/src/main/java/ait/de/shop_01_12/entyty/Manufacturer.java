package ait.de.shop_01_12.entyty;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private String country;
    @OneToMany(mappedBy = "manufacturer")
    private List<Product> products;


}
