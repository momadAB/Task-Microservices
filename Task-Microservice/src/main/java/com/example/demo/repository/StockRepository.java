package com.example.demo.repository;

import com.example.demo.entity.StockEntity;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<StockEntity, Long> {

    Iterable<StockEntity> findByItem(String item);
}
