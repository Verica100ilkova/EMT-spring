package mk.ukim.finki.lab2emt191069.service;

import mk.ukim.finki.lab2emt191069.model.Book;
import mk.ukim.finki.lab2emt191069.model.Country;
import mk.ukim.finki.lab2emt191069.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> save(String name, String continent);

    Optional<Country> edit(Long id, String name, String continent);

    void deleteById(Long id);
}
