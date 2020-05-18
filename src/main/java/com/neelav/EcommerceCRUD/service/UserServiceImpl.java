package com.neelav.EcommerceCRUD.service;

import com.neelav.EcommerceCRUD.exceptions.UserNotFoundException;
import com.neelav.EcommerceCRUD.models.Users;
import com.neelav.EcommerceCRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Users> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Users getUser(String userId) {
        Optional<Users> user= userRepository.findById(userId);

        if(user.isPresent())
            return user.get();
        else
            throw new UserNotFoundException("User does not Exist");
    }

    @Override
    public Users createUsers(Users user) {
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(String email) {
        Optional<Users> user = userRepository.findById(email);

        if(user.isPresent())
        {
            userRepository.delete(user.get());
            return "User Deleted Successfully";
        }
        else
            throw new UserNotFoundException("User does not Exist");
    }

    @Override
    public Users updateUser(Users user) {
        return userRepository.save(user);
    }
}
