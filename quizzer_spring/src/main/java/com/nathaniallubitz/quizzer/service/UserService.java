package com.nathaniallubitz.quizzer.service;

import com.nathaniallubitz.quizzer.entity.User;
import com.nathaniallubitz.quizzer.pojo.UserPOJO;
import com.nathaniallubitz.quizzer.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserPOJO getUserById(Integer id) {
        return new UserPOJO(userRepository.findOne(id));
    }

    @Transactional
    public UserPOJO addUser(UserPOJO user) {
        User u = new User(user);
        u.setPwHash(BCrypt.hashpw(u.getPwHash(), BCrypt.gensalt()));
        userRepository.save(u);
        return new UserPOJO(u);
    }
}
