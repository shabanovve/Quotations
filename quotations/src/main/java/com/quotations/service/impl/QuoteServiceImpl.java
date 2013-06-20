package com.quotations.service.impl;

import com.quotations.dao.QuoteDao;
import com.quotations.entity.Quote;
import com.quotations.service.QuoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("quoteService")
@Transactional(readOnly = true)
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteDao quoteDao;

    @Override
    public Quote findByQuoteStr(String quoteStr) {
        return quoteDao.findById(quoteStr);
    }

    @Override
    @Transactional(readOnly = false)
    public void saveQuote(Quote quote) {
        quoteDao.saveQuote(quote);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteQuote(String quoteStr) {
        Quote quote = quoteDao.findById(quoteStr);
        if (quote != null) {
            quoteDao.delete(quote);
        }
    }

    @Override
    public List<Quote> findQuotes(String quoteStr) {
        return quoteDao.findQuotes(quoteStr);
    }
}
