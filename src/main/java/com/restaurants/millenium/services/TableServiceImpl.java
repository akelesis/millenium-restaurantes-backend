package com.restaurants.millenium.services;

import com.restaurants.millenium.domain.Table;
import com.restaurants.millenium.repositories.TablesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableServiceImpl implements TableService {
    private final TablesRepository tablesRepository;

    public TableServiceImpl(TablesRepository tablesRepository) {
        this.tablesRepository = tablesRepository;
    }

    @Override
    public Table findTableById(Long id) {
        return tablesRepository.getOne(id);
    }

    @Override
    public List<Table> findAllTables() {
        return tablesRepository.findAll();
    }
}
