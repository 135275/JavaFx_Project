/**
 * Application entry point — tests database connectivity.
 */
public class MainApp {
    public static void main(String[] args) {
        if (DBConnection.testConnection()) {
            System.out.println("Database connected successfully!");
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }
}