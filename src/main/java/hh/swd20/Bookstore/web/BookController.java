package hh.swd20.Bookstore.web;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
 @Autowired
 private BookRepository brepository;
 
 @Controller
 public class CategoryController {
 @Autowired
 private CategoryRepository crepository;
 
    
 @RequestMapping(value="/books", method = RequestMethod.GET)
 public @ResponseBody List<Book> bookListRest() {	
     return (List<Book>) brepository.findAll();
 }
 
 
 @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
 public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
 	return brepository.findById(bookId);
 }      
 
 @RequestMapping(value="/books", method = RequestMethod.POST)
 public @ResponseBody Book saveStudentRest(@RequestBody Book book) {	
 	return brepository.save(book);
 }
    
@RequestMapping(value="/booklist")
    public String bookList(Model model) {
    model.addAttribute("books", brepository.findAll());
            return "booklist";
        }

 

@RequestMapping(value = "/addbook")
public String addBook(Model model){
  model.addAttribute("book", new Book ());
  model.addAttribute("categories", crepository.findAll());
    return "addbook";
}     

 

@RequestMapping(value = "/save", method = RequestMethod.POST)
public String save(Book book){
    brepository.save(book);
    return "redirect:booklist";
}    

 

@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
@PreAuthorize("hasAuthority('ADMIN')")
public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    brepository.deleteById(bookId);
    return "redirect:../booklist";
}
}
}

