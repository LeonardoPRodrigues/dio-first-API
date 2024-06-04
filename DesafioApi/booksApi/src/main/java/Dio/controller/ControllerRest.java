package Dio.controller;


import Dio.domain.model.Book;
import Dio.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class ControllerRest {

    @Autowired
    private BooksService booksService;

    @GetMapping
    public ResponseEntity<Iterable<Book>> findAll(){
        return ResponseEntity.ok(booksService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id){
        return ResponseEntity.ok(booksService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> delete(@PathVariable Integer id){
        booksService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody Book book){
        booksService.post(book);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id ,@RequestBody Book book){
        booksService.put(id, book);
        return ResponseEntity.ok(book);
    }

}
