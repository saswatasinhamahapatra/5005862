// src/main/java/com/example/librarymanagement/MainApp.java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Load the Spring context from the applicationContext.xml file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean from the Spring context
        BookService bookService = (BookService) context.getBean("bookService");

        // Test the configuration
        System.out.println("BookService bean: " + bookService);
        System.out.println("BookRepository bean: " + bookService.getBookRepository());
    }
}
