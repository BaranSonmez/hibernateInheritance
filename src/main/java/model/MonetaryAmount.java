package model;

import enums.CurrencyUnit;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@Embeddable
public class MonetaryAmount {

    @Enumerated(EnumType.STRING)
    private CurrencyUnit currencyUnit;

    private Double price;

    public MonetaryAmount() {
    }

    public MonetaryAmount(CurrencyUnit currencyUnit, Double price) {
        this.currencyUnit = currencyUnit;
        this.price = price;
    }

    public CurrencyUnit getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(CurrencyUnit currencyUnit) {
        this.currencyUnit = currencyUnit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonetaryAmount that = (MonetaryAmount) o;
        return currencyUnit == that.currencyUnit && price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyUnit, price);
    }

}
