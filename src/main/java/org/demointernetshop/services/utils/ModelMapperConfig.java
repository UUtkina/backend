package org.demointernetshop.services.utils;

import org.demointernetshop.dto.product.ProductDto;
import org.demointernetshop.entity.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        TypeMap<Product, ProductDto> typeMap = modelMapper.createTypeMap(Product.class, ProductDto.class);
        typeMap.addMappings(mapper -> {
            mapper.map(src -> src.getCategory().getId(), ProductDto::setCategory);
            mapper.map(src -> src.getManufacturer().getId(), ProductDto::setManufacturer);
        });
        return modelMapper;
    }
}
