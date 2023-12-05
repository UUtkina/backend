package ait.de.shop_01_12.entyty;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "name")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Good name must contain latin letters and digit only")
    @Size(min = 3, max = 15, message = "Good name length must be between 3 and 15")
    private String name;

    @Size(min = 15, max = 100, message = "Description name length must be between 3 and 15")
    private String description;

    private Double price;

    @NotBlank(message = "name supplier")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Supplier name must contain latin letters and digit only")
    @Size(min = 3, max = 15, message = "Supplier name length must be between 3 and 15")
    private String supplier;

}
