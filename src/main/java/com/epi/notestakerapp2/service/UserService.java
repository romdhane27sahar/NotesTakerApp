package com.epi.notestakerapp2.service;

import com.epi.notestakerapp2.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {
    public User saveUser(User user);
    public boolean existEmailCheck(String email);


}