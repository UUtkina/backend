package ait.de.shop_01_12.dto.product;

import ait.de.shop_01_12.dto.product.CategoryDTO;
import ait.de.shop_01_12.dto.product.ManufacturerDTO;
import ait.de.shop_01_12.dto.product.ProductInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponseDTO {
    private Integer id;
    private String name;
    private String description;
    private CategoryDTO category;
    private ManufacturerDTO manufacturer;
    private ProductInfoDTO productInfo;
}
