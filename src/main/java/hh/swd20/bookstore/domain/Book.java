package hh.swd20.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private String year;
	private String isbn;
	private String price;
	
	@ManyToOne
	@JsonIgnoreProperties ("category") 
	@JoinColumn(name= "categoryId")
	private Category category;
	
	public Book() {
		
		this.title = null;
		this.author = null;
		this.year = null;
		this.isbn = null;
		this.price = null;
		
		
		
	}
	
	public Book (String title, String author, String year, String isbn, String price, Category category) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category; 
		
	}
	public void setId (Long id) {
		this.id = id;
	}
	
	public void setTitle (String title) {
		this.title = title;
		
	}
	
	public void setAuthor (String author) {
		this.author = author;
		
	}
	
	public void setYear (String year) {
		this.year = year;
		
	}
	
	public void setIsbn (String isbn) {
		this.isbn = isbn;
		
	}
	
	public void setPrice (String price) {
		this.price = price;
		
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	public Long getId() {
		return id;
	
	}
	
	public String getTitle() {
		return title;
		
	}
	
	public String getAuthor() {
		return author;
		
	}
	
	public String getYear() {
		return year;
		
	}
	
	public String getIsbn() {
		return isbn;
		
	}
	
	public String getPrice() {
		return price;
	}
	
	public Category getCategory(Category category) {
		return category;
		
	}
	
	public void setName(Category category) {
		this.category = category;
	}
	
	
	
	@Override
	public String toString() {
		
		return "Book [id =" + id + ", title=" + title + ", author=" + author + ",year=" + year + ", isbn=" + isbn + ", price=" + price + "]";
	}
	
}
