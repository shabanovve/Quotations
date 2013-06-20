package com.quotations.dao.impl;

import com.quotations.dao.QuoteDao;
import com.quotations.entity.Quote;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuoteDaoImpl extends AbstractDaoImpl<Quote, String> implements QuoteDao {

    protected QuoteDaoImpl() {
        super(Quote.class);
    }

    @Override
    public void saveQuote(Quote quote) {
        saveOrUpdate(quote);
    }

    @Override
    public List<Quote> findQuotes(String quoteStr) {
        return findByCriteria(Restrictions.like("quoteStr", quoteStr, MatchMode.START));
    }
}
