import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product(productId=" + productId + ", productName=" + productName + ", category=" + category + ")";
    }
}

class ECommercePlatform {
    ArrayList<Product> products;
    ArrayList<Product> sortedProducts;

    public ECommercePlatform(ArrayList<Product> products) {
        this.products = products;
        this.sortedProducts = new ArrayList<>(products);
        Collections.sort(this.sortedProducts, Comparator.comparing(p -> p.productName));
    }

    public Product linearSearch(String productName) {
        for (Product product : products) {
            if (product.productName.equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public Product binarySearch(String productName) {
        int left = 0, right = sortedProducts.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int compare = sortedProducts.get(mid).productName.compareTo(productName);
            if (compare == 0) {
                return sortedProducts.get(mid);
            } else if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", "Electronics"));
        products.add(new Product(2, "Shirt", "Clothing"));
        products.add(new Product(3, "Book", "Books"));
        products.add(new Product(4, "Headphones", "Electronics"));
        products.add(new Product(5, "Shoes", "Footwear"));

        ECommercePlatform platform = new ECommercePlatform(products);

        // Linear Search
        System.out.println("Linear Search:");
        Product result = platform.linearSearch("Book");
        System.out.println(result);

        // Binary Search
        System.out.println("\nBinary Search:");
        result = platform.binarySearch("Book");
        System.out.println(result);

        // Analysis
        System.out.println("\nTime Complexity Analysis:");
        System.out.println("Linear Search:");
        System.out.println("Best Case: O(1)");
        System.out.println("Average Case: O(n)");
        System.out.println("Worst Case: O(n)");

        System.out.println("\nBinary Search:");
        System.out.println("Best Case: O(1)");
        System.out.println("Average Case: O(log n)");
        System.out.println("Worst Case: O(log n)");

        System.out.println("\nDiscussion:");
        System.out.println("For an e-commerce platform with a large number of products, binary search is more suitable due to its O(log n) time complexity. However, it requires the product list to be sorted. Linear search is simpler but less efficient with a time complexity of O(n), making it less suitable for large datasets.");
    }
}
