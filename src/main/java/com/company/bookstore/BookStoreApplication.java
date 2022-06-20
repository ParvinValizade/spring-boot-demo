package com.company.bookstore;

import com.company.bookstore.model.Book;
import com.company.bookstore.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {

    private final BookRepository bookRepository;

    public BookStoreApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = Book.builder()
                .name("Outliers")
                .author("Malcolm Gladwell")
                .price(13.0)
                .stock(2)
                .build();

        Book book2 = Book.builder()
                .name("Dahi")
                .author("Teador Draizer")
                .price(10.0)
                .stock(10)
                .build();

        Book book3 = Book.builder()
                .name("Yad")
                .author("Albert Kamyu")
                .price(8.7)
                .stock(5)
                .build();

        bookRepository.saveAll(Arrays.asList(book1,book2,book3));


    }
}
