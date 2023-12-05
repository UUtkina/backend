package ait.de.shop_01_12.entyty;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
