package org.project1.library.models;

public class Book {

    private int book_id;
    private String book_name;
    private String book_author;
    private int book_year;

    public Book() {
    }

    public Book(int bookId, String book_name, String book_author, int book_year) {
        this.book_id = bookId;
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_year = book_year;
    }

    public int getBookId() {
        return book_id;
    }

    public void setBookId(int bookId) {
        this.book_id = bookId;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public int getBook_year() {
        return book_year;
    }

    public void setBook_year(int book_year) {
        this.book_year = book_year;
    }
}
