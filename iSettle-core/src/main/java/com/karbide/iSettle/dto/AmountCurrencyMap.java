package com.karbide.iSettle.dto;

/**
 * Created by deepeshuniyal on 04/12/16.
 */
public class AmountCurrencyMap {
    private Float amt;
    private Long currency_code;

    public Float getAmt() {
        return amt;
    }

    public void setAmt(Float amt) {
        this.amt = amt;
    }

    public Long getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(Long currency_code) {
        this.currency_code = currency_code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AmountCurrencyMap that = (AmountCurrencyMap) o;

        return getCurrency_code() != null ? getCurrency_code().equals(that.getCurrency_code()) : that.getCurrency_code() == null;

    }

    @Override
    public int hashCode() {
        return getCurrency_code() != null ? getCurrency_code().hashCode() : 0;
    }
}
