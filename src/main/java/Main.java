import br.com.mariojp.solid.srp.*;

public class Main {

	public static void main(String[] args) {
		System.setProperty("tax.rate", "0.08");

		Order o = new Order();
		o.add(new Item("Café", 8.0, 2));
		o.add(new Item("Bolo", 12.5, 1));

		TaxCalculator taxCalculator = new TaxCalculator();
		ReceiptFormatter formatter = new ReceiptFormatter();
		ReceiptService receiptService = new ReceiptService(taxCalculator, formatter);

		String receipt = receiptService.generate(o);
		System.out.println(receipt);
	}
}
