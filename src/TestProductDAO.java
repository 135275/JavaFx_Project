public class TestProductDAO {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();

        // Add product
        Product p1 = new Product("Laptop", 5, 75000);
        dao.addProduct(p1);

        // Fetch products
        for (Product p : dao.getAllProducts()) {
            System.out.println(p.getName() + " | " + p.getQuantity() + " | " + p.getPrice());
        }
    }
}