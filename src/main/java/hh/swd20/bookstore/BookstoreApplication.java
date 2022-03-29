package hh.swd20.bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;
import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository ) 
	{return (args) -> {

		log.info("add books");
	
	crepository.save(new Category ("Romance"));
	//Category c1 = new Category ("Sci-fi");
	crepository.save(new Category ("Sci-fi"));
	//Category c2 = new Category ("Thriller");
	crepository.save(new Category ("Thriller"));
	
	
	 brepository.save(new Book("1000 Years of Joys and Sorrows"," Ai Weiwei", "2019", "124-245-22", "29,99",crepository.findByName("Romance").get(0)));
	 brepository.save(new Book("Afterparties","Anthony Veasna So", "2021", "324-275-22", "19,99", crepository.findByName("Thriller").get(0)));
	 brepository.save(new Book("Aliens", "Dave Zapalsky", "1995", "235-5245-36", "24,99", crepository.findByName("Sci-fi").get(0)));
	 
	 User user1 = new User("user", "$2a$10$kVRZJPFQAFLsrzcIfGUjd.SOLDiZFYf7z4aTZkC10/dsmei./HvjG", "user@gmail.com", "USER");
	 User user2 = new User("admin", "$2a$10$ZEHllgOjoQCMhqLJvMyGg.tuRawl/AgKhCHaq8xs5EUUSkIGUt.P2", "admin@gmail.com", "ADMIN");
	 urepository.save(user1);
	 urepository.save(user2);
	 
	 
	 log.info("fetch all books");
	 for (Book book : brepository.findAll()) {
	 log.info(book.toString());
	}
	
	log.info("fetch all categories");
	for (Category category : crepository.findAll()) {
		log.info(category.toString());}
	};}
	}

	
