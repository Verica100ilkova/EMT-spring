package mk.ukim.finki.lab2emt191069.repository;

import mk.ukim.finki.lab2emt191069.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    void deleteByName(String name);
}
