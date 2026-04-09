import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/inventory_db",
                    "postgres",
                    "your_password"
            );
        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
}