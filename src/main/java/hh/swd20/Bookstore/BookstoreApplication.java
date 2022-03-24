package hh.swd20.Bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;
import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;



 
@SpringBootApplication
public class BookstoreApplication {
    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
    
    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

 

    @Bean
    public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
        return (args) -> {
            log.info("save a couple of books");
            
            Category category1 = new Category("Scifi");
            crepository.save(category1);
            Category category2 = new Category("Action");
            crepository.save(category2);
            Category category3 = new Category("History");
            crepository.save(category3);
            
            
            brepository.save(new Book("J.K Rowling", "Harry Potter ja Kuoleman varjelukset", 3678901, 2007, category1));
            brepository.save(new Book("Timo Parvela", "Ella ja kaverit", 2578901, 2022, category2));    
            
            User user1 = new User("user", "$2a$10$cOuVmzF5t8WpGtgPy9/lVuBjp8RuAw64RC7pwduJ03vDb8jnGOePi", "USER", "student@gmail.com");
			User user2 = new User("admin", "$2a$10$BHUqUC1FhsEK2q7TTQu1MuhYbMwFvI2aEXvjgaEeqpS39YKv3bHP6", "ADMIN", "admin@gmail.com");
			urepository.save(user1);
			urepository.save(user2);
            
            log.info("fetch all books");
            for (Book book : brepository.findAll()) {
                log.info(book.toString());

            }
        };
    }
}

