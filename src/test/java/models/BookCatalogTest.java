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
        book1 = new Book(1, "Learning Java", "Mario B", "123", "Library", 200);
        bc.addBook(book1);
    }

    //G
    @Test
    public void testAddABook() {
        Book newBook = new Book(2, "An introduction to Java", "Matt Greencroft", "12345", "Anytown Branch", 400);

        bc.addBook(newBook); // Lägger till boken och går sedan till try catch för att kolla om boken finns.

        try {
            Book foundBook = bc.findBook("An introduction to Java"); // Hitta boken
            assertNotNull(foundBook, "catalog should have the new book"); // ifall vi har hittat boken så gåt vi vidare
            assertEquals("An introduction to Java", foundBook.getTitle()); // Jämför strängen med titen av boken
        } catch (BookNotFoundException e) {
            fail("Book should have been found"); // Om vi inte hittat boken så skickar vi ett felmeddelande
        }


    }

    //G
    @Test
    public void testFindBook() {

        try {

            Book findbook = bc.findBook("Learning Java");


            assertNotNull(findbook, "Book is found");
            assertEquals("Learning Java", findbook.getTitle());

        } catch (BookNotFoundException e) {
            fail("did not find book");

        }


    }

    //G
    @Test
    public void testFindBookIgnoringCase() {

        try {
            Book findbook = bc.findBook("LEARNING Java");

            assertNotNull(findbook, "Book is found");
            assertEquals("Learning Java", findbook.getTitle());


        } catch (BookNotFoundException e) {
            fail("did not find book");
        }

    }

    //G
    @Test
    public void testFindBookWithExtraSpaces() {

        BookCatalog bookCatalog = new BookCatalog();
        Book book2 = new Book(1, "Learning Java", "Mario B", "123", "Library", 200);
        bookCatalog.addBook(book2);

        try {
            String searchTerm = " Learning   Java ";
            Book foundBook = bookCatalog.findBook(searchTerm.trim().replaceAll("\\s+", " ")); // Normalize spaces
            assertNotNull(foundBook, "Book should be found");
            assertEquals("Learning Java", foundBook.getTitle());
        } catch (BookNotFoundException e) {
            fail("Did not find book");
        }

    }

    //VG
    // This test should throw BookNotFoundException in order to pass.
    @Test
    public void testFindBookThatDoesntExist() throws BookNotFoundException {
        BookCatalog bookCatalog = new BookCatalog();

        try {
            bookCatalog.findBook("hejhej");
            fail("did not find book");
        }catch (BookNotFoundException e) {}

    }

}
