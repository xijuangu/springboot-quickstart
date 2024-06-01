package com.example.springbootquickstart.controller;

import com.example.springbootquickstart.mapper.UserMapper;
import com.example.springbootquickstart.pojo.User;
import com.example.springbootquickstart.pojo.UserType;
import com.example.springbootquickstart.pojo.dinfo;
import com.example.springbootquickstart.pojo.pinfo;
import com.example.springbootquickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        boolean isAdded = userService.addUser(user);
        if (isAdded) {
            if(user.getUserType() == UserType.Pat){
                pinfo patient = new pinfo();
                patient.setpIDCard(user.getIdentification());
                patient.setpPasswordHash(user.getPassword());
                patient.setpName(user.getUsername());
                userService.saveOrUpdatePinfo(patient);
            }
            if(user.getUserType() == UserType.Doc){
                dinfo doctor = new dinfo();
                doctor.setDId(user.getIdentification());
                doctor.setDPasswordHash(user.getPassword());
                doctor.setDName(user.getUsername());
                userService.setDinfo(doctor);
            }
            return new ResponseEntity<>("User has been registered successfully.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to register the user.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/login/{id}/{password}")
    public ResponseEntity<?> userLogin(@PathVariable("id") int id,
                                       @PathVariable("password") String password){
        User user = userService.getUserById(id);
        if( user == null )
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else if( userMapper.userLogin(id, password) != null ){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
