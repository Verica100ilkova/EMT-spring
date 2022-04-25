package mk.ukim.finki.lab2emt191069.service;

import mk.ukim.finki.lab2emt191069.model.Author;
import mk.ukim.finki.lab2emt191069.model.Country;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findById(Long id);
    Optional<Author> save(String name, String surname, Long countryId);
    Optional<Author> edit(Long id,String name, String surname, Long countryId);
    void deleteById(Long id);
}
