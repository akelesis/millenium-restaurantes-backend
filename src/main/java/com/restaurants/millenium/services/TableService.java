package com.restaurants.millenium.services;

import com.restaurants.millenium.domain.Table;

import java.util.List;

public interface TableService {

    public Table findTableById(Long id);

    public List<Table> findAllTables();
}
