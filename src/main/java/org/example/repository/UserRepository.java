package org.example.repository;

import org.example.model.User;

public interface UserRepository {
    User save(String userId, String userPw);
    User findById(String userId);


}