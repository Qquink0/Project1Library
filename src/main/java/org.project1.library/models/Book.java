package org.project1.library.models;

public class Book {

    private int bookId;
    private String nameBook;
    private String author;
    private int year;

    public Book() {
    }

    public Book(int bookId, String nameBook, String author, int year) {
        this.bookId = bookId;
        this.nameBook = nameBook;
        this.author = author;
        this.year = year;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
