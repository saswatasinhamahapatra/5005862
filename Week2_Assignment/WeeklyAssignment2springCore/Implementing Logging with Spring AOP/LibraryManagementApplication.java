package com.example.librarymanagement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Call a method to trigger logging
        bookService.someMethod();

        // Verify that the BookRepository is injected
        if (bookService.getBookRepository() != null) {
            System.out.println("BookRepository has been successfully injected into BookService.");
        } else {
            System.out.println("Failed to inject BookRepository into BookService.");
        }
    }
}
