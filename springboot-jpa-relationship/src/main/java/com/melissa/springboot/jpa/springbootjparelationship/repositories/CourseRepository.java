package com.melissa.springboot.jpa.springbootjparelationship.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.melissa.springboot.jpa.springbootjparelationship.entities.Course;


public interface CourseRepository extends CrudRepository <Course,Long>{
  @Query("SELECT c FROM Course c JOIN FETCH c.students WHERE c.id = :id")
   Optional<Course> findOneWithStudents(Long id);


}
