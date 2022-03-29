package hh.swd20.bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Category {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	@JsonIgnoreProperties("category") 
	private List<Book> book;
	
	public Category() {
		
		this.name = null;
		
	}
	
	public Category (String name) {
		this.name = name;
		
	}

	public void setId (Long categoryId) {
		this.categoryId = categoryId;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	

	public Long getcategoryId() {
		return categoryId;
		
	}
	
	public String getName() {
		return name; 
	}
	
	public List<Book> getBook (){
		return book;
	}
	
	public void setBook(List<Book> book) {
	this.book = book; 
	}
	@Override
	public String toString() {
		
		return " Category [categoryId =" + categoryId + ", name=" + name + "]";
	}
}
