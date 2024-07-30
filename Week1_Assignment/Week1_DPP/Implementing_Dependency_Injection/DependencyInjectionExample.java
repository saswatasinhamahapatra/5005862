// src/main/java/DependencyInjectionExample.java

public class DependencyInjectionExample {

    // Define Customer class
    static class Customer {
        private final int id;
        private final String name;

        public Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    // Define CustomerRepository interface
    interface CustomerRepository {
        Customer findCustomerById(int id);
    }

    // Implement CustomerRepository interface
    static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public Customer findCustomerById(int id) {
            // Dummy implementation
            return new Customer(id, "John Doe");
        }
    }

    // Define CustomerService class
    static class CustomerService {
        private final CustomerRepository customerRepository;

        // Constructor Injection
        public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        public Customer getCustomerById(int id) {
            return customerRepository.findCustomerById(id);
        }
    }

    // Main class to demonstrate Dependency Injection
    public static void main(String[] args) {
        // Instantiate the concrete repository
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject the repository into the service
        CustomerService service = new CustomerService(repository);

        // Use the service to find a customer
        Customer customer = service.getCustomerById(1);
        System.out.println("Customer ID: " + customer.getId() + ", Name: " + customer.getName());
    }
}
