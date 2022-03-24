package hh.swd20.Bookstore.web;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	 private CategoryRepository crepository;
	  
	    
	@RequestMapping(value="/categorylist", method = RequestMethod.GET)
	    public String categoryList(Model model) {
		model.addAttribute("categories", crepository.findAll());
	            return "categorylist";
	        }

	 

	@RequestMapping(value = "/addcategory", method = RequestMethod.GET)
	public String addCategory(Model model){
	  model.addAttribute("category", new Category ());
	    return "addcategory";
	}     

	 

	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String save(Category category){
	    crepository.save(category);
	    return "redirect:categorylist";
	}    

	@RequestMapping(value="/categories/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("id") Long Id) {
	return crepository.findById(Id);
	}

	}



