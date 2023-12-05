package ait.de.shop_01_12.entyty;

import jakarta.persistence.*;
import jakarta.persistence.Entity;


import java.time.LocalDateTime;

@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String email;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    private LocalDateTime createData;
    private LocalDateTime lastVisitData;
}