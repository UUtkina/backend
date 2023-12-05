package ait.de.shop_01_12.entyty;

import jakarta.persistence.*;


@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;


}











    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;

    @Size(min = 15, max = 100, message = "Description name length must be between 3 and 15")
    private String description;

    private Double price;

    @NotBlank(message = "name supplier")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Supplier name must contain latin letters and digit only")
    @Size(min = 3, max = 15, message = "Supplier name length must be between 3 and 15")
    private String supplier;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Manufacturer> manufacturers;

    private int quantity;*/

