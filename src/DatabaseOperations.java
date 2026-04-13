import java.util.List;

/**
 * Generic utility class for performing common operations on any DAO.
 * Demonstrates: Generics — generic method that works with any GenericDAO<T>.
 */
public class DatabaseOperations {

    /**
     * Generic method to print all items from any DAO.
     * Uses bounded type parameter and generic DAO.
     */
    public static <T> void printAll(GenericDAO<T> dao) throws Exception {
        List<T> items = dao.getAll();
        if (items.isEmpty()) {
            System.out.println("No items found.");
        } else {
            for (T item : items) {
                System.out.println(item);
            }
        }
    }

    /**
     * Generic method to count items from any DAO.
     */
    public static <T> int countAll(GenericDAO<T> dao) throws Exception {
        return dao.getAll().size();
    }
}
