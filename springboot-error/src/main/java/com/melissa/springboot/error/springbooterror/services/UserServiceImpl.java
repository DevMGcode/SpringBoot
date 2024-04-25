package com.melissa.springboot.error.springbooterror.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.melissa.springboot.error.springbooterror.models.domain.User;

@Service
public class UserServiceImpl implements UserService{

  private List<User> users;
  public UserServiceImpl(){
    this.users= new ArrayList<>();
    users.add(new User(1L,"Lina","Ortega"));
    users.add(new User(2L,"Marcela","Ramirez"));
    users.add(new User(3L,"Maria","Gomez"));
    users.add(new User(4L,"Jose","Hortua"));
    users.add(new User(5L,"Alex","Lasso"));
  }

  @Override
  public List<User> findAll() {
    
    return users;
  }

  @Override
  public  Optional<User> findById(Long id) {
    User user = null;
    for (User u : users) {
      if(u.getId().equals(id)){
        user=u;
        break;
      }
    }
    
    return Optional.ofNullable(user);
  }

}
