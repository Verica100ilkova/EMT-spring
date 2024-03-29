package mk.ukim.finki.lab2emt191069.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.lab2emt191069.model.Category;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Author author;
    private Integer availableCopies;

    private Boolean mark=false;

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }
}
