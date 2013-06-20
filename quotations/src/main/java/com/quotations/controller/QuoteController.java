package com.quotations.controller;

import com.quotations.entity.Quote;
import com.quotations.service.QuoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

@Controller
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showQuoteForm(Model model) {
        model.addAttribute("quote",new Quote());
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveQuote( Model model, Quote quote) {
        Quote existing = quoteService.findByQuoteStr(quote.getQuoteStr());
        if (existing != null) {
            model.addAttribute("status", "exist");
            return "index";
        }
        quote.setCreatedOn(new Date());
        quoteService.saveQuote(quote);
        model.addAttribute("saved", "success");
        
        showAllQuotes(model);
        
        return "index";
    }
    

    private void showAllQuotes(Model model) {
        Quote empltyQuote = new Quote();
        empltyQuote.setQuoteStr("");
        searchQuote(model, empltyQuote);
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchQuote(Model model, Quote quote) {
        List<Quote> quotes = quoteService.findQuotes(quote.getQuoteStr());
        model.addAttribute("quotes", quotes);
        model.addAttribute("search", true);
        return "index";
    }

    @RequestMapping(value = "/edit/{quoteStr}", method = RequestMethod.GET)
    public String updateQuote(Model model, @PathVariable String quoteStr) {
        Quote quote = quoteService.findByQuoteStr(quoteStr);
        model.addAttribute("quote", quote);
        return "update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateQuote( Model model, Quote quote) {
        quoteService.saveQuote(quote);
        model.addAttribute("saved", "success");
        return "update";
    }
    @RequestMapping(value = "/delete/{quoteStr}", method = RequestMethod.GET)
    public String deleteQuote(Model model, @PathVariable String quoteStr) {
        quoteService.deleteQuote(quoteStr);
        model.addAttribute("deleted", "success");
        model.addAttribute("quote", new Quote());
        showAllQuotes(model);
        return "index";
    }

}
