public class MainApp {
    public static void main(String[] args) {
        if (DBConnection.getConnection() != null) {
            System.out.println("Database connected successfully!");
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }
}