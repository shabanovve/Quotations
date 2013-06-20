package com.quotations.service;

import com.quotations.entity.Quote;

import java.util.List;

public interface QuoteService {

    Quote findByQuoteStr(String userName);
    void saveQuote(Quote user);
    void deleteQuote(String userName);
    List<Quote> findQuotes(String user);
}
