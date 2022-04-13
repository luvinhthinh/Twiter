package com.twt.demo.repository;

import org.springframework.data.repository.CrudRepository;  
import com.twt.demo.model.Reaction;  

public interface ReactionRepository extends CrudRepository<Reaction, Integer> {

}
