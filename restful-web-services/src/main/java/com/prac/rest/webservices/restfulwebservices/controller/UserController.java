package com.prac.rest.webservices.restfulwebservices.controller;

import com.prac.rest.webservices.restfulwebservices.dao.UserDaoService;
import com.prac.rest.webservices.restfulwebservices.entities.Post;
import com.prac.rest.webservices.restfulwebservices.entities.User;
import com.prac.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("users")
@Slf4j
public class UserController {
    private UserDaoService userDaoService;
    @Autowired
    public UserController(UserDaoService userDaoService){
        this.userDaoService = userDaoService;
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return  ResponseEntity.ok(userDaoService.getAllUsers());
    }
    @GetMapping("/{userId}")
    public EntityModel<User> getUserById(@PathVariable int userId){
        User user = userDaoService.getUserById(userId);
        if(user == null){
            throw  new UserNotFoundException("No User Found");
        }
        EntityModel<User> entityModel = EntityModel.of(userDaoService.getUserById(userId));
        WebMvcLinkBuilder webMvcLinkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
        entityModel.add(webMvcLinkBuilder.withRel("all-users"));
        return  entityModel;
    }
    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        User user1 = userDaoService.addUser(user);
//        return new ResponseEntity<>(user1,HttpStatus.CREATED);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user1.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userDaoService.deleteUserById(id);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getAllPosts(@PathVariable int id){
        User user = userDaoService.getUserById(id);
        if(user == null){
            throw  new UserNotFoundException("No User Found");
        }
        log.info("getAllPosts () : hello");
        return user.getPosts();
    }

}
