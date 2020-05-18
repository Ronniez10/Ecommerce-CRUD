package com.neelav.EcommerceCRUD.resource;

import com.neelav.EcommerceCRUD.exceptions.UserNotFoundException;
import com.neelav.EcommerceCRUD.models.Users;
import com.neelav.EcommerceCRUD.repository.UserRepository;
import com.neelav.EcommerceCRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Users> getAll()
    {
        return userService.getAll();
    }

    @GetMapping("/{userId}")
    public Users getUser(@PathVariable String userId)
    {
       return userService.getUser(userId);
    }

    @PostMapping()
    public Users createUsers(@RequestBody Users user)
    {
        return userService.createUsers(user);
    }

    @DeleteMapping("/{email}")
    public String deleteUser(@PathVariable String email)
    {
        return userService.deleteUser(email);
    }

    @PutMapping()
    public Users updateUser(@RequestBody Users user)
    {
       return userService.updateUser(user);
    }
}
