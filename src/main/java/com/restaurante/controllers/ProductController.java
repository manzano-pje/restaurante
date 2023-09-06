package com.restaurante.controllers;

import com.restaurante.dtos.ProductsDto;
import com.restaurante.services.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductsService productsService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody ProductsDto productsDto){
        ProductsDto retorno = productsService.create(productsDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id").
                buildAndExpand(retorno.getIdProduct()).toUri();
        return ResponseEntity.created(uri).body("Product is registered.");
    }

}
