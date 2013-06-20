package com.quotations.service;

import com.quotations.entity.Quote;

import java.util.List;

public interface QuoteService {

    Quote findByQuoteStr(String quoteStr);
    void saveQuote(Quote quote);
    void deleteQuote(String quoteStr);
    List<Quote> findQuotes(String quote);
}
