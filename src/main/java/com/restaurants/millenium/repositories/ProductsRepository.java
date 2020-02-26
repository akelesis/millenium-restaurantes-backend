package com.restaurants.millenium.repositories;

import com.restaurants.millenium.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long> {
}
