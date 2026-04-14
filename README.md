# Inventory Management System

A **JavaFX-based Inventory Management System** with PostgreSQL database integration, developed as part of the **BBT 2202: Advanced Object Oriented Programming** course project.

---

## Features

| Feature | Description |
|---------|-------------|
| **Add Products** | Capture product name, quantity, and price via a form |
| **View Products** | Display all products in a TableView with ID, name, quantity, price, and display info |
| **Update Stock** | Select a product and update its quantity |
| **Delete Products** | Remove a product from the inventory with confirmation |
| **Zero-Quantity Alert** | Products with zero quantity are displayed in **red text** |
| **Input Validation** | All form inputs are validated before submission |
| **CSS Styling** | Modern, styled UI using a custom JavaFX CSS stylesheet |

---

## Project Structure

```
JavaFx_Project/
├── src/
│   ├── Main.java               # JavaFX Application — unified GUI entry point
│   ├── MainApp.java            # Console entry point (DB connection test)
│   ├── Item.java               # Abstract base class (encapsulation, abstraction)
│   ├── Product.java            # Concrete product class (inheritance, polymorphism)
│   ├── GenericDAO.java         # Generic DAO interface (generics)
│   ├── ProductDAO.java         # Product data access object (implements GenericDAO<Product>)
│   ├── DatabaseOperations.java # Generic utility methods for any DAO
│   ├── DBConnection.java       # PostgreSQL JDBC connection manager
│   ├── TestProductDAO.java     # Console-based DAO test class
│   └── styles.css              # JavaFX CSS stylesheet
├── database.sql                # SQL script to create the products table
└── README.md
```

---

## OOP Concepts Demonstrated

### 1. Encapsulation
- All model fields are `private` with public getters and setters.
- See: `Item.java`, `Product.java`

### 2. Inheritance
- `Product` extends the abstract class `Item`.
- `Item` defines common attributes (`id`, `name`) and an abstract method `getDisplayInfo()`.
- See: `Item.java` → `Product.java`

### 3. Polymorphism

**Method Overriding:**
- `Product.getDisplayInfo()` overrides the abstract method from `Item`.
- `Product.toString()` overrides `Item.toString()`, which itself overrides `Object.toString()`.

**Method Overloading:**
- `Product` has three overloaded constructors: default, with id, and without id.
- `Item` has three overloaded constructors as well.
- `ProductDAO.updateStock()` is an overloaded convenience method alongside the full `update()` method.

### 4. Generics
- `GenericDAO<T>` — a generic interface defining CRUD operations for any entity type.
- `ProductDAO implements GenericDAO<Product>` — concrete implementation bound to `Product`.
- `DatabaseOperations.printAll(GenericDAO<T> dao)` — a generic static method that works with any DAO.
- `DatabaseOperations.countAll(GenericDAO<T> dao)` — another generic utility method.

### 5. Exception Handling
- `DBConnection.getConnection()` throws `SQLException` with specific messages for missing drivers.
- `ProductDAO` methods propagate `SQLException` to the caller.
- The JavaFX GUI catches all exceptions and displays user-friendly error alerts.
- Input validation prevents `NumberFormatException` from invalid form entries.

---

## User Interface (JavaFX)

The application uses a **unified single-window GUI** built with JavaFX:

- **BorderPane** layout as the root container
  - **Top:** Title bar with application name
  - **Center:** `TableView` displaying all products (with red rows for zero-quantity items)
  - **Right:** Forms panel with "Add Product" and "Update Stock" sections, plus a "Delete" button
  - **Bottom:** Status bar showing operation results

### Layouts Used
- `BorderPane` — main application layout
- `VBox` — vertical stacking for forms and table container
- `HBox` — horizontal layout for title bar, table header, and status bar
- `Region` — flexible spacer

### Advanced UI Components
- `TableView` with custom `TableColumn` definitions and cell value factories
- Custom `TableRow` factory for conditional red-text styling on zero-quantity products
- `Alert` dialogs for error/warning/confirmation messages
- `TextField` with prompt text for form inputs

### CSS Styling
A custom `styles.css` stylesheet provides:
- Dark header and status bar (`#2c3e50`)
- Blue primary buttons (`#3498db`)
- Red danger buttons (`#e74c3c`)
- Card-style form sections with drop shadows
- Hover effects on table rows and buttons
- Focused input field highlighting

---

## Database Setup

### Prerequisites
- **PostgreSQL** installed and running on `localhost:5432`
- A database named `inventory_db`

### Create the Database
```sql
CREATE DATABASE inventory_db;
```

### Create the Products Table
Run the `database.sql` script:
```sql
CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    quantity INT,
    price DOUBLE PRECISION
);
```

### Connection Configuration
Database credentials are configured in `DBConnection.java`:
```java
private static final String URL = "jdbc:postgresql://localhost:5432/inventory_db";
private static final String USER = "postgres";
private static final String PASSWORD = "your_password";
```

---

## How to Run

### Prerequisites
- **Java 17+** (JDK)
- **JavaFX SDK** (21.0.2 or compatible)
- **PostgreSQL JDBC Driver** (`postgresql-42.7.x.jar`)
- **PostgreSQL** database server

### Running from IDE (IntelliJ IDEA)
1. Open the project in IntelliJ IDEA.
2. Ensure the JavaFX SDK and PostgreSQL JDBC driver are added as project libraries.
3. Set up the `inventory_db` database in PostgreSQL and run `database.sql`.
4. Run `Main.java` as the main class.

### Running from Command Line
```bash
javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -cp .:postgresql-42.7.10.jar src/*.java

java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -cp src:postgresql-42.7.10.jar Main
```

---

## Git Log (Development Steps)

| Commit | Description |
|--------|-------------|
| **Step 1** | Add OOP structure — abstract `Item` base class, `Product` inheritance, polymorphism (overloading/overriding) |
| **Step 2** | Add Generics — `GenericDAO<T>` interface, `ProductDAO` implements it, `DatabaseOperations` generic utilities |
| **Step 3** | Add robust exception handling — `DBConnection` throws `SQLException`, proper try-catch throughout |
| **Step 4** | Add JavaFX unified GUI — `TableView`, Add/Update/Delete forms, CSS styling, red text for zero-qty, input validation |
| **Step 5** | Add project documentation (README) |

---

## Technologies Used

- **Java 17**
- **JavaFX 21** (Controls, FXML)
- **PostgreSQL** (Database)
- **JDBC** (Database connectivity)
- **CSS** (JavaFX styling)
