package org.demointernetshop.services.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.demointernetshop.dto.cart.CartDto;
import org.demointernetshop.dto.order.OrderDto;
import org.demointernetshop.dto.product.*;
import org.demointernetshop.dto.user.UserDto;
import org.demointernetshop.dto.user.UserRegistrationDto;
import org.demointernetshop.entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Converters {
    public CategoryDto formCategoryToDto(Category category) {
        return new CategoryDto(category.getId(), category.getCategoryName());
    }

    public CartDto fromCartToDto(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setId(cart.getId());
        cartDto.setUserId(cart.getUser().getId());

        List<ProductShortInfoDto> productShortInfoDtos = new ArrayList<>();
        for (CartItem cartItem : cart.getCartItems()) {
            Product product = cartItem.getProduct();
            ProductShortInfoDto productShortInfoDto = new ProductShortInfoDto();
            productShortInfoDto.setId(product.getId());
            productShortInfoDto.setName(product.getName());
            productShortInfoDto.setPrice(product.getProductInfo().getPrice());
            productShortInfoDto.setQuantity(cartItem.getQuantity());
            productShortInfoDtos.add(productShortInfoDto);
        }

        cartDto.setProducts(productShortInfoDtos);
        return cartDto;


    }

    public List<ManufacturerDto> fromManufacturerToDtos(List<Manufacturer> manufacturerList) {
        return manufacturerList.stream()
                .map(manufacturer -> {
                    ManufacturerDto manufacturerDto = new ManufacturerDto();
                    manufacturerDto.setId(manufacturer.getId());
                    manufacturerDto.setName(manufacturer.getName());
                    manufacturerDto.setCountry(manufacturer.getCountry());
                    return manufacturerDto;
                })
                .toList();

    }

    public ManufacturerDto fromManufacturerToDto(Manufacturer manufacturer) {
        return ManufacturerDto.builder()
                .id(manufacturer.getId())
                .name(manufacturer.getName())
                .country(manufacturer.getCountry())
                .build();

    }

    public ProductDto fromProductToDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .category(formCategoryToDto(product.getCategory()))
                .manufacturer(fromManufacturerToDto(product.getManufacturer()))
                .build();
    }

    public OrderDto convertToOrderDto(Order order, Integer userId, List<ProductShortInfoDto> productDtos) {
        return new OrderDto(
                order.getId(),
                userId,
                productDtos,
                order.getOrderStatus().getStatus(),
                order.getPaymentStatus().getStatus(),
                order.getPaymentMethod().getMethod(),
                order.getCreateData()
        );
    }

    public User fromDto(UserRegistrationDto userRegistrationDto) {
        User newUser = new User();
        if (userRegistrationDto.getEmail() != null) {
            newUser.setEmail(userRegistrationDto.getEmail());
        }
        if (userRegistrationDto.getPassword() != null) {
            newUser.setPassword(userRegistrationDto.getPassword());
        }
        if (userRegistrationDto.getUsername() != null) {
            newUser.setUsername(userRegistrationDto.getUsername());
        }
        if (userRegistrationDto.getPhone() != null) {
            newUser.setPhone(userRegistrationDto.getPhone());
        }
        return newUser;

    }

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .role(user.getRole().getName().toString())
                .email(user.getEmail())
                .phone(user.getPhone())
                .createData(user.getCreateData())
                .lastVisitData(user.getLastVisitData())
                .build();
    }

}
