package org.project1.library.dao;

import org.project1.library.models.Book;
import org.project1.library.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(book_name, book_author, book_year) VALUES (?, ?, ?)",
                book.getBook_name(), book.getBook_author(), book.getBook_year());
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE book_id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public void update(int id, Book book) {
        jdbcTemplate.update("UPDATE Book SET book_name=?, book_author=?, book_year=? WHERE book_id=?",
                book.getBook_name(), book.getBook_author(), book.getBook_year(), id);
    }

    public Person join(int id) {
        return jdbcTemplate.query("select person_name from person" +
                        " join book b on person.person_id = b.person_id where b.book_id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void set(int id, Person person) {
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE book_id=?", person.getPerson_id(), id);
    }

    public void clear(int id) {
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE book_id=?", null, id);
    }
}
