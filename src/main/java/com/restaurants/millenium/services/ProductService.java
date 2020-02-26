package com.restaurants.millenium.services;

import com.restaurants.millenium.domain.Product;

import java.util.List;

public interface ProductService {

    Product findProductById(Long id);

    List<Product> findAllProducts();

    Product saveProduct(Product product);

}
