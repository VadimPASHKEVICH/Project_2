package com.leasig_firm.leasing.service;

import com.leasig_firm.leasing.domain.User;
import com.leasig_firm.leasing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    public UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user){
        userRepository.createUser(user);
    }

    public void updateUser(User user){
        userRepository.updateUser(user);
    }

    public ArrayList<User> getAllUser() {
        return userRepository.getAllUser();
    }

    public User getUserById(int id){
        return userRepository.getUserById(id);
    }

    public void deleteUser(User user){
        userRepository.deleteUser(user);
    }
}
