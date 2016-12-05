package com.karbide.iSettle.dto;

/**
 * Created by deepeshuniyal on 04/12/16.
 */
public class AmountCurrencyMap {
    private Float amt;
    private int currency_code;

    public Float getAmt() {
        return amt;
    }

    public void setAmt(Float amt) {
        this.amt = amt;
    }

    public int getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(int currency_code) {
        this.currency_code = currency_code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AmountCurrencyMap that = (AmountCurrencyMap) o;

        return getCurrency_code() == that.getCurrency_code();

    }

    @Override
    public int hashCode() {
        return getCurrency_code();
    }
}
