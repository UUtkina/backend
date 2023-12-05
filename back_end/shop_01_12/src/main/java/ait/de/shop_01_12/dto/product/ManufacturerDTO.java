package ait.de.shop_01_12.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ManufacturerDTO {
    private Integer id;
    private String name;
    private String country;
}
