package com.restaurants.millenium.bootstrap;

import com.restaurants.millenium.repositories.ProductsRepository;
import com.restaurants.millenium.repositories.TablesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final ProductsRepository productsRepository;
    private final TablesRepository tablesRepository;

    public BootstrapData(ProductsRepository productsRepository, TablesRepository tablesRepository) {
        this.productsRepository = productsRepository;
        this.tablesRepository = tablesRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
