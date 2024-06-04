package Dio.service;

import Dio.domain.model.Book;

public interface BooksService {

    Iterable<Book> findAll();

    Book findById(Integer id);

    void delete(Integer id);

    void post(Book book);

    void put(Integer id, Book book);

}
