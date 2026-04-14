import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for Product entities.
 * Implements GenericDAO<Product> — demonstrating generics applied to a concrete type.
 * All methods throw Exception for proper exception handling upstream.
 */
public class ProductDAO implements GenericDAO<Product> {

    // ADD PRODUCT
    @Override
    public void add(Product product) throws SQLException {
        String query = "INSERT INTO products (name, quantity, price) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getQuantity());
            stmt.setDouble(3, product.getPrice());

            stmt.executeUpdate();
        }
    }

    // GET ALL PRODUCTS
    @Override
    public List<Product> getAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products ORDER BY id";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price")
                );
                products.add(product);
            }
        }

        return products;
    }

    // UPDATE PRODUCT (used for updating stock quantity and other fields)
    @Override
    public void update(Product product) throws SQLException {
        String query = "UPDATE products SET name = ?, quantity = ?, price = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getQuantity());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getId());

            int rows = stmt.executeUpdate();
            if (rows == 0) {
                throw new SQLException("Product with ID " + product.getId() + " not found.");
            }
        }
    }

    // DELETE PRODUCT
    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM products WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
            if (rows == 0) {
                throw new SQLException("Product with ID " + id + " not found.");
            }
        }
    }

    // GET PRODUCT BY ID
    @Override
    public Product getById(int id) throws SQLException {
        String query = "SELECT * FROM products WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Product(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("quantity"),
                            rs.getDouble("price")
                    );
                }
            }
        }

        return null;
    }

    // UPDATE STOCK — convenience method for updating only quantity (method overloading)
    public void updateStock(int productId, int newQuantity) throws SQLException {
        String query = "UPDATE products SET quantity = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, newQuantity);
            stmt.setInt(2, productId);

            int rows = stmt.executeUpdate();
            if (rows == 0) {
                throw new SQLException("Product with ID " + productId + " not found.");
            }
        }
    }
}