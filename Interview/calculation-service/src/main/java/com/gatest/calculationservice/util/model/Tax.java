package com.gatest.calculationservice.util.model;

import java.util.Objects;

public class Tax {
   private String category;
   private double taxPercent;
   private boolean taxExempt;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(double taxPercent) {
        this.taxPercent = taxPercent;
    }

    public boolean isTaxExempt() {
        return taxExempt;
    }

    public void setTaxExempt(boolean taxExempt) {
        this.taxExempt = taxExempt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tax tax = (Tax) o;
        return Double.compare(tax.taxPercent, taxPercent) == 0 &&
                taxExempt == tax.taxExempt &&
                Objects.equals(category, tax.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, taxPercent, taxExempt);
    }
}
