class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

public class OrderSorter {
    public static void main(String[] args) {
        Order[] orders = {
                new Order(1, "Alice", 99.99),
                new Order(2, "Bob", 59.99),
                new Order(3, "Charlie", 119.99),
                new Order(4, "Dave", 29.99)
        };

        System.out.println("Original Orders:");
        printOrders(orders);

        // Bubble Sort
        Order[] bubbleSortedOrders = orders.clone();
        bubbleSort(bubbleSortedOrders);
        System.out.println("\nBubble Sorted Orders:");
        printOrders(bubbleSortedOrders);

        // Quick Sort
        Order[] quickSortedOrders = orders.clone();
        quickSort(quickSortedOrders, 0, orders.length - 1);
        System.out.println("\nQuick Sorted Orders:");
        printOrders(quickSortedOrders);
    }

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    public static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;

                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        // Swap orders[i + 1] and orders[high] (or pivot)
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
