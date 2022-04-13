package com.twt.demo.repository;

import org.springframework.data.repository.CrudRepository;  
import com.twt.demo.model.Message;  

public interface MessageRepository extends CrudRepository<Message, Integer> {

}
