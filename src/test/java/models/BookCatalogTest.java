package models;

import static org.junit.jupiter.api.Assertions.*;

import models.Book;
import models.BookCatalog;
import models.BookNotFoundException;
import org.junit.jupiter.api.Test;

public class BookCatalogTest {

	private BookCatalog bc;
	private Book book1;

	public BookCatalogTest() {
		bc = new BookCatalog();
		book1 = new Book(1,"Learning Java","Mario B","123","Library",200);
		bc.addBook(book1);
	}

	//G
	@Test
	public void testAddABook() {
		Book newBook = new Book(1,"An introduction to Java","Matt Greencroft","12345","Anytown Branch", 400);

		bc.addBook(newBook);

		assertTrue(bc.getBooks().contains(newBook), "catalog should have the new book");




	}

	//G
	@Test
	public void testFindBook() {
      BookCatalog bookCatalog = new BookCatalog();
	  Book book2 =  new Book(1,"Learning Java","Mario B","123","Library",200);
	  Book book3 = new Book(2, "Github", "pelle p", "12345", "HelloBranch", 300);

	  bookCatalog.addBook(book2);
	  bookCatalog.addBook(book3);

	  try {

		 Book findbook =  bookCatalog.findBook("Learning Java");


		 assertNotNull(findbook, "Book is found");
		 assertEquals("Learning Java", findbook.getTitle());

	  } catch (BookNotFoundException e) {
		  fail("did not find book");

	  }



	}

	//G
	@Test
	public void testFindBookIgnoringCase() {

	}

	//G
	@Test
	public void testFindBookWithExtraSpaces() {

	}

	//VG
	// This test should throw BookNotFoundException in order to pass.
	@Test
	public void testFindBookThatDoesntExist() throws BookNotFoundException {

	}

}
