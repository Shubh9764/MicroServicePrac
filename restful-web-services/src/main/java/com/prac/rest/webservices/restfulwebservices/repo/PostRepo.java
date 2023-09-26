package com.prac.rest.webservices.restfulwebservices.repo;

import com.prac.rest.webservices.restfulwebservices.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post,Integer> {
}
