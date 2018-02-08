package com.nathaniallubitz.quizzer.service;

import com.nathaniallubitz.quizzer.entity.Token;
import com.nathaniallubitz.quizzer.entity.User;
import com.nathaniallubitz.quizzer.exception.PasswordMismatchException;
import com.nathaniallubitz.quizzer.exception.SessionNotFoundException;
import com.nathaniallubitz.quizzer.exception.UserDefinedException;
import com.nathaniallubitz.quizzer.exception.UserNotFoundException;
import com.nathaniallubitz.quizzer.pojo.UserPOJO;
import com.nathaniallubitz.quizzer.repository.TokenRepository;
import com.nathaniallubitz.quizzer.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.sql.Date;
import java.time.Instant;

@Service
public class UserService {

    private UserRepository userRepository;
    private TokenRepository tokenRepository;

    public UserService(UserRepository userRepository, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
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

    public boolean validateLogin(UserPOJO user) throws UserDefinedException {
        User u = userRepository.findUserByEmail(user.getEmail());
        if(u == null){
            throw new UserNotFoundException();
        }
        boolean correct = BCrypt.checkpw(user.getPwHash(), u.getPwHash());
        if(!correct){
            throw new PasswordMismatchException();
        }
        return correct;
    }
    public UserPOJO getUserByToken(String token) throws SessionNotFoundException {
        Token t = tokenRepository.findTokenByToken(token);
        if(t == null){
            throw new SessionNotFoundException();
        }
        return new UserPOJO(t.getUser());
    }


    public String createToken(UserPOJO user) throws UserDefinedException {
        if(validateLogin(user)){
            Token t = new Token();
            t.setUser(userRepository.findUserByEmail(user.getEmail()));
            t.setToken(generateToken());
            t.setExpiration(Date.from(Instant.now()).getTime()+(1000 * 60 * 30));
            tokenRepository.save(t);
            return t.getToken();
        }
        return null;
    }

    private String generateToken(){
        SecureRandom random = new SecureRandom();
        int length = random.nextInt(10) + 20;
        String characterChoice = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@☺♥#$%^&*()-";
        String build = "";
        int position = 0;
        while(position < length){
            build += characterChoice.toCharArray()[random.nextInt(characterChoice.length())];
            position++;
        }
        return build;
    }

    @Scheduled(fixedDelay = 5000)
    public void filterExpiredTokens(){
        tokenRepository.findAll().stream().filter(x -> x.getExpiration() < Date.from(Instant.now()).getTime()).forEach(tokenRepository::delete);
    }
}
