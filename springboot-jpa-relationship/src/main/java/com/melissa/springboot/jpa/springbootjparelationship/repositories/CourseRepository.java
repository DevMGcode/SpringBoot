package com.melissa.springboot.jpa.springbootjparelationship.repositories;

import org.springframework.data.repository.CrudRepository;

import com.melissa.springboot.jpa.springbootjparelationship.entities.Course;

public interface CourseRepository extends CrudRepository <Course,Long>{

}
