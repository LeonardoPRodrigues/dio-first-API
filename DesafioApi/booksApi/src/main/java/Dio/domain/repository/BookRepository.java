package Dio.domain.repository;

import Dio.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

    boolean existsByName(String name);
    boolean existsById(Integer id);
}

