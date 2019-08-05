package com.example.book;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void saveTest() {
        Book book = new Book();
        book.setName("My Book");
        bookRepository.save(book);
        Assert.assertNotNull(book.getId());
    }

    @Test
    public void findTest() {
        Book book = new Book();
        book.setName("Book to find");
        bookRepository.save(book);
        final Optional<Book> optionalBook = bookRepository.findById(book.getId());
        Assert.assertTrue(optionalBook.isPresent());
    }
}
