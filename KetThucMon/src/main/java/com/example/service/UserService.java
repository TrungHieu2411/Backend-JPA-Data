package com.example.service;

import com.example.dto.UserDto;
import com.example.model.User;

import java.util.List;

public interface UserService {
	//luu thong tin vao UserDto
    void saveUser(UserDto userDto);
    //tim kiem email de dang nhap
    User findByEmail(String email);
    
    //-------------------
    List<User> findAllUsers();

    public User findOneUser(Long id);

    public void deleteOneUser(Long id);

    public void updateOneUser(User user);
}