public class OrderSorter {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Order[] ordersForBubble = {
            new Order("O001", "Ravi Kumar", 1250.00),
            new Order("O002", "Sneha Patil", 300.50),
            new Order("O003", "Amit Sharma", 4500.00),
            new Order("O004", "Priya Nair", 780.25),
            new Order("O005", "Karan Mehta", 99.99)
        };

        bubbleSort(ordersForBubble);
        System.out.println("Sorted by Bubble Sort:");
        for (Order order : ordersForBubble) {
            System.out.println(order);
        }

        Order[] ordersForQuick = {
            new Order("O001", "Ravi Kumar", 1250.00),
            new Order("O002", "Sneha Patil", 300.50),
            new Order("O003", "Amit Sharma", 4500.00),
            new Order("O004", "Priya Nair", 780.25),
            new Order("O005", "Karan Mehta", 99.99)
        };

        quickSort(ordersForQuick, 0, ordersForQuick.length - 1);
        System.out.println("Sorted by Quick Sort:");
        for (Order order : ordersForQuick) {
            System.out.println(order);
        }
    }
}
