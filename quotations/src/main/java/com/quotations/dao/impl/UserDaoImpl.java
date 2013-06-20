package com.quotations.dao.impl;

import com.quotations.dao.QuoteDao;
import com.quotations.entity.Quote;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<Quote, String> implements QuoteDao {

    protected UserDaoImpl() {
        super(Quote.class);
    }

    @Override
    public void saveQuote(Quote user) {
        saveOrUpdate(user);
    }

    @Override
    public List<Quote> findQuotes(String userName) {
        return findByCriteria(Restrictions.like("userName", userName, MatchMode.START));
    }
}
