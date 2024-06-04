package Dio.service.impl;

import Dio.domain.model.Book;
import Dio.domain.repository.BookRepository;
import Dio.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BooksImplements implements BooksService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void post(Book book) {
        if(book.getName() != null && bookRepository.existsByName(book.getName())){
            throw new IllegalArgumentException("This book already exist");
        }
        bookRepository.save(book);
    }



    @Override
    public void put(Integer id, Book book) {
        Optional<Book> idBook = bookRepository.findById(id);
        if(idBook.isPresent() && !bookRepository.equals(book)){
            bookRepository.save(book);
        }else throw new NoSuchElementException("This Book not exists");
    }
}
