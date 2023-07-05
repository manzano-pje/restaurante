package com.restaurante.dtos;

import com.restaurante.entities.Products;
import com.restaurante.enums.UnitOfMeasurementEnum;
import java.math.BigDecimal;

public class ProductsDto {

    private Integer idProduct;
    private Integer idGroup;
    private Integer idSubGroup;
    private String name;
    private UnitOfMeasurementEnum productType;
    private BigDecimal price;
    private Integer minimumStock;
    private Integer stock;

    public ProductsDto(Products products){
        this.idProduct = products.getIdProduct();
        this.idGroup = products.getIdGroup();
        this.idSubGroup = products.getIdSubGroup();
        this.name = products.getName();
        this.productType = products.getProductType();
        this.price = products.getPrice();
        this.minimumStock = products.getMinimumStock();
        this.stock = products.getStock();
    }
}
