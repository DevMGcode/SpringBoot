package com.melissa.springboot.jpa.springbootjparelationship.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.melissa.springboot.jpa.springbootjparelationship.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

  @Query("SELECT s FROM Student s JOIN FETCH s.courses WHERE s.id = :id")
   Optional<Student>  findOneWithCourses(Long id);

  
}
