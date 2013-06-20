package com.quotations.dao.impl;

import com.quotations.dao.UserDao;
import com.quotations.entity.Quote;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<Quote, String> implements UserDao {

    protected UserDaoImpl() {
        super(Quote.class);
    }

    @Override
    public void saveUser(Quote user) {
        saveOrUpdate(user);
    }

    @Override
    public List<Quote> findUsers(String userName) {
        return findByCriteria(Restrictions.like("userName", userName, MatchMode.START));
    }
}
