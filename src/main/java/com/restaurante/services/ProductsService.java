package com.restaurante.services;

import com.restaurante.dtos.ProductsDto;
import com.restaurante.entities.Products;
import com.restaurante.exceptions.product.ProductAlerdyExistException;
import com.restaurante.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductsService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    public ProductsDto create(ProductsDto productsDto){
        Optional productOptional = productRepository.findByName(productsDto.getName());
        if(productOptional.isPresent()){
            throw new ProductAlerdyExistException();
        }
        Products product = mapper.map(productsDto, Products.class);
        productRepository.save(product);
        return mapper.map(product, ProductsDto.class);
    }
}
