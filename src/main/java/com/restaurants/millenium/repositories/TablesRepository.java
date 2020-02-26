package com.restaurants.millenium.repositories;

import com.restaurants.millenium.domain.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TablesRepository extends JpaRepository<Table, Long> {
}
