import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Quantity: " + quantity + ", Price: " + price;
    }
}

class Inventory {
    private ArrayList<Product> productList;

    public Inventory() {
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public boolean updateProduct(int productId, int quantity, double price) {
        for (Product product : productList) {
            if (product.getProductId() == productId) {
                product.setQuantity(quantity);
                product.setPrice(price);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(int productId) {
        return productList.removeIf(product -> product.getProductId() == productId);
    }

    public void displayProducts() {
        if (productList.isEmpty()) {
            System.out.println("No products in the inventory.");
        } else {
            for (Product product : productList) {
                System.out.println(product);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    Product product = new Product(productId, productName, quantity, price);
                    inventory.addProduct(product);
                    System.out.println("Product added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Product ID to update: ");
                    productId = scanner.nextInt();
                    System.out.print("Enter new Quantity: ");
                    quantity = scanner.nextInt();
                    System.out.print("Enter new Price: ");
                    price = scanner.nextDouble();
                    if (inventory.updateProduct(productId, quantity, price)) {
                        System.out.println("Product updated successfully.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    productId = scanner.nextInt();
                    if (inventory.deleteProduct(productId)) {
                        System.out.println("Product deleted successfully.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4:
                    inventory.displayProducts();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}