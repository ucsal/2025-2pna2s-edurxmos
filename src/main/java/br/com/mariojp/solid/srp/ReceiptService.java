package br.com.mariojp.solid.srp;

public class ReceiptService {

	private final TaxCalculator taxCalculator;
	private final ReceiptFormatter receiptFormatter;

	public ReceiptService(TaxCalculator taxCalculator, ReceiptFormatter receiptFormatter) {
		this.taxCalculator = taxCalculator;
		this.receiptFormatter = receiptFormatter;
	}

	public String generate(Order order) {
		double subtotal = 0;
		for (int i = 0; i < order.getItems().size(); i++) {
			var item = order.getItems().get(i);
			subtotal += item.getUnitPrice() * item.getQuantity();
		}

		double total = taxCalculator.calculate(order);
		double tax = total - subtotal;

		return receiptFormatter.format(order, subtotal, tax, total);
	}
}