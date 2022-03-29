package hh.swd20.bookstore.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository crepository;
	
	
	
	
	 @RequestMapping(value="/category", method = RequestMethod.GET)
	    public @ResponseBody List<Category> getCategoryRest() {	
	        return (List<Category>) crepository.findAll();
	    }    
	 
	    @RequestMapping(value="/category/{categoryId}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("categoryId") Long dId) {	
	    	return crepository.findById(dId);
	    } 
	
	 
	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String categories (Model model) {
		model.addAttribute("categories", crepository.findAll());
		return "categorylist";
	}
	
	@RequestMapping(value="/addcategory")
	public String addCategory (Model model ) {
		model.addAttribute("category",new Category());
		return "addcategory";
	}
	
	
	@RequestMapping(value="/savecategory", method=RequestMethod.POST)
	public String saveCategory (Category category) {
		crepository.save(category);
		return "redirect:categorylist";
			
	}

}
