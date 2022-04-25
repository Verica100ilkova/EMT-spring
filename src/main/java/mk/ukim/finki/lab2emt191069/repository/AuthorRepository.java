package mk.ukim.finki.lab2emt191069.repository;

import mk.ukim.finki.lab2emt191069.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    void deleteByName(String name);
}
