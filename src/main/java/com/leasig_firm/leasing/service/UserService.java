package com.leasig_firm.leasing.service;
import com.leasig_firm.leasing.domain.User;
import com.leasig_firm.leasing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class UserService {
    UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    public void createUser(User user){userRepository.save(user);}

    public void updateUser(User user){userRepository.saveAndFlush(user);}

    public ArrayList<User> getAllUser() {return (ArrayList<User>) userRepository.findAll();}

    public User getUserById(int id){
       return userRepository.getById(id);
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }
}
