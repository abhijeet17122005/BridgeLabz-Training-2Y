package OOPS.Class_Objects;

class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void addItem(int qty) {
        quantity += qty;
    }

    public void removeItem(int qty) {
        if (quantity >= qty)
            quantity -= qty;
    }

    public void displayTotal() {
        System.out.println("Total Cost: " + (price * quantity));
    }

    public static void main(String[] args) {
        CartItem item = new CartItem("Book", 200, 2);
        item.addItem(3);
        item.removeItem(1);
        item.displayTotal();
    }
}
