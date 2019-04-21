package ku.shop;

public class Product {
    private double price;
    private String name;
    private int quantity;

    public Product(String name, double price) {
        this.name = name;
        setPrice(price);
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("Price must be not be negative zero");
        this.price = price;
    }

    public void stock(int quantity) {
        if (quantity < 0)
            throw new IllegalArgumentException("Stock number must be positive");
        this.quantity += quantity;
    }

    public void pick(int quantity) {
        if (quantity > this.quantity)
            throw new IllegalArgumentException("Insufficient product quantity");
        this.quantity -= quantity;
    }
}
