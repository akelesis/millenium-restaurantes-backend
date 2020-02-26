package com.restaurants.millenium.services;

import com.restaurants.millenium.domain.Product;
import com.restaurants.millenium.repositories.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductsRepository productsRepository;

    public ProductServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public Product findProductById(Long id) {
        return productsRepository.getOne(id);
    }

    @Override
    public List<Product> findAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productsRepository.save(product);
    }
}
