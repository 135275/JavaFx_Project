/**
 * Abstract base class for all inventory items.
 * Demonstrates: Encapsulation (private fields + getters/setters),
 *               Abstraction (abstract method),
 *               Polymorphism (toString override, abstract getDisplayInfo).
 */
public abstract class Item {

    private int id;
    private String name;

    // Default constructor
    public Item() {
    }

    // Parameterized constructor
    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Constructor overloading (polymorphism — overloading)
    public Item(String name) {
        this.name = name;
    }

    // Getters and Setters (encapsulation)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Abstract method — each subclass must describe itself differently.
     * This is polymorphism through overriding.
     */
    public abstract String getDisplayInfo();

    // Overriding Object.toString() (polymorphism — overriding)
    @Override
    public String toString() {
        return "Item{id=" + id + ", name='" + name + "'}";
    }
}
