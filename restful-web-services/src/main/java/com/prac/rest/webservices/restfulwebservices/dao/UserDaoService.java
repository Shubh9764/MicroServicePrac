package com.prac.rest.webservices.restfulwebservices.dao;

import com.prac.rest.webservices.restfulwebservices.entities.User;
import com.prac.rest.webservices.restfulwebservices.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserDaoService {
    private static int userCount = 0;
    private static ArrayList<User> users = new ArrayList<>( Arrays.asList(
            new User(++userCount,"Adam", LocalDate.now().minusYears(30)),
            new User(++userCount,"Adam", LocalDate.now().minusYears(25)),
            new User(++userCount,"Adam", LocalDate.now().minusYears(20))
    )
    );
    @Autowired
    UserRepo userRepo;
    //get allUsers
    public List<User> getAllUsers(){
        return userRepo.findAll();
//        return  users;
    }
    public User getUserById(int id){
       return  userRepo.findById(id).orElse(null);
//        return users.stream().filter( u -> u.getId() == id).findFirst().orElse(null);
    }
    public User addUser(User user){
        return  userRepo.save(user);
//        user.setId(++userCount);
//        users.add(user);
//        return user;
    }

    public void deleteUserById(int id){

//        users.removeIf( u -> u.getId() == id);
        userRepo.deleteById(id);
    }


}
