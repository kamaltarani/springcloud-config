package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Manufacturer;

@Repository
public interface ManufaturerRepository extends MongoRepository<Manufacturer, Integer> {

}
