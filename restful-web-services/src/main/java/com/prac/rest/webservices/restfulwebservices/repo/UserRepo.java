package com.prac.rest.webservices.restfulwebservices.repo;

import com.prac.rest.webservices.restfulwebservices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
