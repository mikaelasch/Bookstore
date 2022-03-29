package hh.swd20.bookstore.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@Controller
public class BookstoreController {
	
	@Autowired
	private BookRepository brepository;
	@Autowired
	private CategoryRepository crepository;
	
	


	
	 @RequestMapping(value="/book", method = RequestMethod.GET)
	    public @ResponseBody List<Book> getBookRest() {	
	        return (List<Book>) brepository.findAll();
	    }    
	 
	    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Book> findCategoryRest(@PathVariable("id") Long bId) {	
	    	return brepository.findById(bId);
	    } 
	
	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String books (Model model) {
		model.addAttribute("books", brepository.findAll());
		return "booklist";
	}
	
	
	@RequestMapping(value="/addbook")
	public String addBook (Model model ) {
		model.addAttribute("book", new Book());
		model.addAttribute("category",crepository.findAll());
		return "addbook";
	}

	
	@RequestMapping(value="/savebook", method=RequestMethod.POST)
	public String saveBook (Book book) {
		brepository.save(book);
		return "redirect:booklist";
			
	}

	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteBook (@PathVariable("id")Long bookId, Model model) {
		brepository.deleteById(bookId);
		return "redirect:../booklist";
		
	}
	

	
}
