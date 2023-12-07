package ait.de.shop_01_12.dto.product;


import lombok.AllArgsConstructor;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "Product", description = "Product data")
public class ProductDto {
    @Schema(description = "Product identifier", example = "1")
    Integer id;
    @Schema(description = "Name of the product", example = "iPhone 15")
    String name;
    @Schema(description = "Description of the product", example = "Latest iPhone model")
    String description;
    @Schema(description = "Category of the product")
    CategoryDto categoryName;
    @Schema(description = "Manufacturer of the product")
    ManufacturerDto manufacturer;
    @Schema(description = "Price of the product", example = "1500.0")
    BigDecimal productPrice;
    @Schema(description = "Quantity of the product", example = "24")
    int productQuantity;
}