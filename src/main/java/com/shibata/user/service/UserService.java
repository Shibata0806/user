package com.shibata.user.service;

import com.shibata.user.entity.User;
import com.shibata.user.exception.UserAlreadyExistsException;
import com.shibata.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> findAll() {
        return this.userMapper.findAll();
    }

    public User findUser(int id) throws Exception {
        Optional<User> user = this.userMapper.findById(id);
        return user.orElseThrow(() -> new Exception("ユーザーが⾒つかりませんでした。"));
    }

    public User insert(String name, String email) {
        Optional<User> userOptional = this.userMapper.findByEmail(email);
        if (userOptional.isPresent()) {
            throw new UserAlreadyExistsException("email : " + email + " already exists");
        }
        User user = new User(name, email);
        userMapper.insert(user);
        return user;
    }

}
