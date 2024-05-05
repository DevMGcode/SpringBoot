package com.melissa.springboot.jpa.springbootjpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.melissa.springboot.jpa.springbootjpa.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{
  
  
} 
