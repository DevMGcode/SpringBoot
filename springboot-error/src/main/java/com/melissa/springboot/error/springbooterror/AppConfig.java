package com.melissa.springboot.error.springbooterror;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.melissa.springboot.error.springbooterror.models.domain.User;

@Configuration
public class AppConfig {

  @Bean
  List<User> users(){
    List<User>users= new ArrayList<>();
    users.add(new User(1L,"Lina","Ortega"));
    users.add(new User(2L,"Marcela","Ramirez"));
    users.add(new User(3L,"Maria","Gomez"));
    users.add(new User(4L,"Jose","Hortua"));
    users.add(new User(5L,"Alex","Lasso"));
    return users;
  }
}
