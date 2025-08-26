package br.com.mariojp.solid.srp;

public class TaxCalculator {

    private final double taxRate;

    public TaxCalculator() {
        this.taxRate = Double.parseDouble(System.getProperty("tax.rate", "0"));
    }

    public double calculate(Order order) {
        double subtotal = order.getItems().stream().mapToDouble(i -> i.getUnitPrice() * i.getQuantity()).sum();
        double tax = subtotal * taxRate;
        return subtotal + tax;
    }
}
