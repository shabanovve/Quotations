package com.quotations.service;

import com.quotations.entity.Quote;

import java.util.List;

public interface UserService {

    Quote findByUserName(String userName);
    void saveUser(Quote user);
    void deleteUser(String userName);
    List<Quote> findUsers(String user);
}
