package com.restaurants.millenium.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private int clientsNumber;
    private String tableName;
    @OneToMany
    private List<Product> products;
    private String status;

}
