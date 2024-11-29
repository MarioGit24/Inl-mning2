package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {

    //G
    @Test
    public void test2EqualBooks() {
        BookCatalogTest bookCatalogTest = new BookCatalogTest();

        Book book = new Book(123, "Hello", "", "", "", 200);
        Book book2 = new Book(123, "Hello", "", "", "", 200);

        assertEquals(book, book2);

    }

    //G
    @Test
    public void test2NonEqualBooks() {
        BookCatalogTest bookCatalogTest = new BookCatalogTest();

        Book book = new Book(123, "Hello", "", "", "", 200);
        Book book2 = new Book(321, "hej", "", "", "", 200);

        assertNotEquals(book, book2);
    }

}
