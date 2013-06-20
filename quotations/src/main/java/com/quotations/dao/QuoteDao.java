package com.quotations.dao;

import com.quotations.entity.Quote;

import java.util.List;

public interface QuoteDao extends AbstractDao<Quote, String> {
    void saveQuote(Quote quote);
    List<Quote> findQuotes(String quoteStr);
}
