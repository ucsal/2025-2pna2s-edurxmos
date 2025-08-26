package br.com.mariojp.solid.srp;

public class ReceiptFormatter {

    public String format(Order order, double subtotal, double tax, double total) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== RECIBO ===\n");

        for (int i = 0; i < order.getItems().size(); i++) {
            var item = order.getItems().get(i);
            sb.append(item.getName()).append(" x").append(item.getQuantity()).append(" = ").append(item.getUnitPrice() * item.getQuantity()).append("\n");
        }

        sb.append("Subtotal: ").append(subtotal).append("\n");
        sb.append("Tax: ").append(tax).append("\n");
        sb.append("Total: ").append(total).append("\n");

        return sb.toString();
    }
}
