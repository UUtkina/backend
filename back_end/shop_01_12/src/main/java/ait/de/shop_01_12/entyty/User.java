package ait.de.shop_01_12.entyty;


import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    public enum Role {
        ADMIN, MANAGER, USER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String username;
    @Enumerated(EnumType.STRING)
    private String role;
    private String email;
    private String phone;
    private LocalDateTime createData;
    private LocalDateTime lastVisitData;


}