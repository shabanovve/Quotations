package com.quotations.service.impl;

import com.quotations.dao.UserDao;
import com.quotations.entity.Quote;
import com.quotations.service.QuoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements QuoteService {

    @Autowired
    private UserDao userDao;

    @Override
    public Quote findByQuoteStr(String userName) {
        return userDao.findById(userName);
    }

    @Override
    @Transactional(readOnly = false)
    public void saveQuote(Quote user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteQuote(String userName) {
        Quote user = userDao.findById(userName);
        if (user != null) {
            userDao.delete(user);
        }
    }

    @Override
    public List<Quote> findQuotes(String user) {
        return userDao.findUsers(user);
    }
}
