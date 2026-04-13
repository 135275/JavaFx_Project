import java.util.List;

/**
 * Generic Data Access Object interface.
 * Demonstrates: Generics — type parameter T allows this interface
 * to be reused for any entity type (Product, or future entities).
 */
public interface GenericDAO<T> {

    void add(T item) throws Exception;

    List<T> getAll() throws Exception;

    void update(T item) throws Exception;

    void delete(int id) throws Exception;

    T getById(int id) throws Exception;
}
