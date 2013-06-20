package com.quotations.dao;

import com.quotations.entity.Quote;

import java.util.List;

public interface UserDao extends AbstractDao<Quote, String> {
    void saveUser(Quote user);
    List<Quote> findUsers(String userName);
}
