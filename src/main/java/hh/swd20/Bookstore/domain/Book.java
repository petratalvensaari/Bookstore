package hh.swd20.Bookstore.domain;

 

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
    @GeneratedValue(strategy=GenerationType.AUTO)
   public Long bookId;
   public String Author;
   public String Title;
   public int ISBN;
   public int Year;
   
   @ManyToOne
   @JsonIgnoreProperties ("books") 
   @JoinColumn(name = "categoryid")
   private Category category;
    
   public Book() {}
   
    public Book(String Author, String Title, int ISBN, int Year, Category category) {
        super();
        this.Author = Author;
        this.Title = Title;
        this.ISBN = ISBN;
        this.Year = Year;
        this.category = category;
    }

 
    

    public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		 this.category=category;
	}


	public Long getId() {
        return bookId;
    }

 

    public void setId(Long id) {
        this.bookId = id;
    }

 

    public String getAuthor() {
        return Author;
    }

 

    public void setAuthor(String Author) {
        this.Author = Author;
    }

 

    public String getTitle() {
        return Title;
    }

 

    public void setTitle(String Title) {
        this.Title = Title;
    }

 

    public int getISBN() {
        return ISBN;
    }

 

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
    
    
    public int getYear() {
        return Year;
    }

 

    public void setYear(int Year) {
        this.Year= Year;
    }
    @Override
    public String toString() {
		if (this.category != null)
    		 return "Book [bookId=" + bookId + ", Author=" + Author + ", Title=" + Title + ", ISBN=" + ISBN + ", Year=" + Year + " Category=" + this.getCategory() +"]";
		else
			return "Book [bookId=" + bookId + ", Author=" + Author + ", Title=" + Title + ", ISBN=" + ISBN + ", YEAR=" + Year + "]";
	}
}
