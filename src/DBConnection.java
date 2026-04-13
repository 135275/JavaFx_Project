import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Manages PostgreSQL database connections.
 * Demonstrates: Exception Handling — catches specific SQL exceptions
 * and provides meaningful error messages.
 */
public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/inventory_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Alan_gesora2000";

    /**
     * Establishes and returns a connection to the PostgreSQL database.
     * Throws SQLException so callers can handle connection failures properly.
     */
    public static Connection getConnection() throws SQLException {
        try {
            // Explicitly load the PostgreSQL driver
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("PostgreSQL JDBC Driver not found. "
                    + "Ensure the driver JAR is in the classpath.", e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Tests whether a database connection can be established.
     * Returns true if successful, false otherwise.
     */
    public static boolean testConnection() {
        try (Connection conn = getConnection()) {
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            System.err.println("Database connection test failed: " + e.getMessage());
            return false;
        }
    }
}