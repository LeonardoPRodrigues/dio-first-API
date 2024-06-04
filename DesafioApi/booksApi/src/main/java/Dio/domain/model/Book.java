package Dio.domain.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "TB_BOOKS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    private String author;

    private LocalDate releaseYear;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(LocalDate releaseYear) {
        this.releaseYear = releaseYear;
    }
}