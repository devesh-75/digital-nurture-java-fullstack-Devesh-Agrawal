import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {

    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] sortedProducts, String name) {
        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = sortedProducts[mid].getProductName().compareToIgnoreCase(name);

            if (comparison == 0) {
                return sortedProducts[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "Bluetooth Speaker", "Electronics"),
            new Product("P002", "Running Shoes", "Footwear"),
            new Product("P003", "Coffee Maker", "Appliances"),
            new Product("P004", "Yoga Mat", "Fitness"),
            new Product("P005", "Backpack", "Accessories")
        };

        Product foundLinear = linearSearch(products, "Coffee Maker");
        System.out.println("Linear search result: " + foundLinear);

        Product[] sortedProducts = products.clone();
        Arrays.sort(sortedProducts, Comparator.comparing(Product::getProductName, String.CASE_INSENSITIVE_ORDER));

        Product foundBinary = binarySearch(sortedProducts, "Yoga Mat");
        System.out.println("Binary search result: " + foundBinary);
    }
}
