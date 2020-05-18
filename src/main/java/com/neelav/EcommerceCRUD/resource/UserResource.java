package com.neelav.EcommerceCRUD.resource;

import com.neelav.EcommerceCRUD.models.Users;
import com.neelav.EcommerceCRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Users> getAll()
    {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    private Users getUser(@PathVariable String userId)
    {
        Optional<Users> user= userRepository.findById(userId);

        if(user.isPresent())
            return user.get();
        else
            throw new NullPointerException();
    }
}
