package com.gatest.calculationservice.viewmodel;

import java.util.Objects;

public class PriceCalculationViewModel {

    private String productId;
    private String productDescription;
    private int quantity;
    private double pricePerUnit;
    private double taxPercent;
    private double totalTax;
    private double total;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(double taxPercent) {
        this.taxPercent = taxPercent;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceCalculationViewModel that = (PriceCalculationViewModel) o;
        return quantity == that.quantity &&
                Double.compare(that.pricePerUnit, pricePerUnit) == 0 &&
                Double.compare(that.taxPercent, taxPercent) == 0 &&
                Double.compare(that.totalTax, totalTax) == 0 &&
                Double.compare(that.total, total) == 0 &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(productDescription, that.productDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productDescription, quantity, pricePerUnit, taxPercent, totalTax, total);
    }
}
