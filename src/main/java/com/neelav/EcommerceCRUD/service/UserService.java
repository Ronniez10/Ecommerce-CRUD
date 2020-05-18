package com.neelav.EcommerceCRUD.service;

import com.neelav.EcommerceCRUD.models.Users;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {

    public List<Users> getAll();

    public Users getUser(@PathVariable String userId);

    public Users createUsers(@RequestBody Users user);

    public String deleteUser(@PathVariable String email);

    public Users updateUser(@RequestBody Users user);
}
