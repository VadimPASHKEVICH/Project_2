package com.leasig_firm.leasing.controller;
import com.leasig_firm.leasing.entity.User;
import com.leasig_firm.leasing.exception.UserNotFoundException;
import com.leasig_firm.leasing.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) throws UserNotFoundException {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, user.getId() != 0 ? HttpStatus.OK : HttpStatus.CONFLICT);
    }

    @GetMapping
    public ResponseEntity<ArrayList<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError o : bindingResult.getAllErrors()) {
                log.warn(o.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        int countChangedRows = userService.createUser(user);
        return new ResponseEntity<>(countChangedRows != 0 ? HttpStatus.NO_CONTENT : HttpStatus.CONFLICT);
    }

    @PutMapping
    public ResponseEntity<User> updateUserById(@RequestBody User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            for(ObjectError o : bindingResult.getAllErrors()){
                log.warn(o.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        int ChangedSome =  userService.updateUserById(user);
        return new ResponseEntity<>(ChangedSome != 0 ? HttpStatus.NO_CONTENT : HttpStatus.CONFLICT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        return new ResponseEntity<>(userService.deleteUserById(id) > 0 ? HttpStatus.NO_CONTENT : HttpStatus.CONFLICT);
    }
}

