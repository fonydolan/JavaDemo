package com.dolan.springboot.repository;

import com.dolan.springboot.model.Visitor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VisitRepository extends MongoRepository<Visitor,String>{

}
