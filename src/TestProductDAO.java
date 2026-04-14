/**
 * Test class for ProductDAO operations.
 * Demonstrates exception handling with try-catch blocks.
 */
public class TestProductDAO {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();

        try {
            // Add product
            Product p1 = new Product("Laptop", 5, 75000);
            dao.add(p1);
            System.out.println("Product added successfully!");

            // Fetch and display all products
            System.out.println("\nAll Products:");
            for (Product p : dao.getAll()) {
                System.out.println(p.getDisplayInfo());
            }

            // Test generic utility
            System.out.println("\nTotal products: " + DatabaseOperations.countAll(dao));

        } catch (Exception e) {
            System.err.println("Error during database operations: " + e.getMessage());
        }
    }
}