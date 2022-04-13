package com.twt.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.twt.demo.model.Emo; 

public interface EmoRepository extends CrudRepository<Emo, Integer> {

}
