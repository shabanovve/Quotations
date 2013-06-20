package com.quotations.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "table_quote")
public class Quote {

    @Id
    @Column (name = "quotestr")
    private String quoteStr;

    @Column (name = "created", nullable = false)
    private Date createdOn;

    public Quote() {
    }

    public Quote(String quoteStr) {
        this.quoteStr = quoteStr;
    }

    public String getQuoteStr() {
        return quoteStr;
    }

    public void setQuoteStr(String quoteStr) {
        this.quoteStr = quoteStr;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quote quote = (Quote) o;

        return quoteStr.equals(quote.quoteStr);
    }

    @Override
    public int hashCode() {
        return 13 * quoteStr.hashCode();
    }
}
