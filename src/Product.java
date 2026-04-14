/**
 * Concrete product class extending Item.
 * Demonstrates: Inheritance (extends Item),
 *               Encapsulation (private fields + getters/setters),
 *               Polymorphism (overrides getDisplayInfo & toString, overloaded constructors).
 */
public class Product extends Item {

    private int quantity;
    private double price;

    // Default constructor
    public Product() {
        super();
    }

    // Constructor with all fields including id (overloading)
    public Product(int id, String name, int quantity, double price) {
        super(id, name);
        this.quantity = quantity;
        this.price = price;
    }

    // Constructor without id — used when adding a new product (overloading)
    public Product(String name, int quantity, double price) {
        super(name);
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters (encapsulation)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Polymorphism — overriding the abstract method from Item
    @Override
    public String getDisplayInfo() {
        return String.format("Product: %s | Qty: %d | Price: %.2f", getName(), quantity, price);
    }

    // Polymorphism — overriding toString from Item (which itself overrides Object.toString)
    @Override
    public String toString() {
        return "Product{id=" + getId() + ", name='" + getName() + "', quantity=" + quantity + ", price=" + price + "}";
    }
}