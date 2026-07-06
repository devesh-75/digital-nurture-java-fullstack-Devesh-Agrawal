import java.util.HashMap;
import java.util.Map;

public class InventoryManagement {
    private Map<String, Product> inventory;

    public InventoryManagement() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
        }
    }

    public void deleteProduct(String productId) {
        inventory.remove(productId);
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public void displayInventory() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        InventoryManagement system = new InventoryManagement();

        system.addProduct(new Product("P001", "Wireless Mouse", 50, 799.00));
        system.addProduct(new Product("P002", "Mechanical Keyboard", 30, 2499.00));
        system.addProduct(new Product("P003", "USB-C Cable", 100, 199.00));

        system.displayInventory();

        system.updateProduct("P002", 25, 2299.00);
        system.deleteProduct("P003");

        System.out.println("After update and delete:");
        system.displayInventory();
    }
}
