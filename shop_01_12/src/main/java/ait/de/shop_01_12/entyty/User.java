package ait.de.shop_01_12.entyty;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ait.de.shop_01_12.entyty.Role;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "First name")
    @Pattern(regexp = "^[A-Za-z0-9]+$",message = "User first name must contain latin letters and digit only")
    private String firstName;

    @NotBlank(message = "Last name")
    @Pattern(regexp = "^[A-Za-z0-9]+$",message = "User last name must contain latin letters and digit only")
    private String lastName;

    @NotBlank(message = "User name")
    @Pattern(regexp = "^[A-Za-z0-9]+$",message = "User name must contain latin letters and digit only")
    private String userName;

    @NotBlank(message = "Email must be not blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password must be not blank")
    @Pattern(regexp = "^[A-Za-z0-9!@#$%&*()]+$",message = "Password must contain latin letters and digit and some special characters only")
    @Size(min = 5, max = 15, message = "Password length must be between 1 and 15")
    private String password;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private boolean isActive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;


}
