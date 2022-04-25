package mk.ukim.finki.lab2emt191069.service.impl;

import mk.ukim.finki.lab2emt191069.exceptions.AuthorNotFound;
import mk.ukim.finki.lab2emt191069.exceptions.CountryNotFound;
import mk.ukim.finki.lab2emt191069.model.Author;
import mk.ukim.finki.lab2emt191069.model.Country;
import mk.ukim.finki.lab2emt191069.repository.AuthorRepository;
import mk.ukim.finki.lab2emt191069.repository.CountryRepository;
import mk.ukim.finki.lab2emt191069.service.AuthorService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Transactional
    @Override
    public Optional<Author> save(String name, String surname, Long countryId) {
        Country country = this.countryRepository.findById(countryId)
                .orElseThrow(() -> new CountryNotFound(countryId));
        this.authorRepository.deleteByName(name);
        return Optional.of(this.authorRepository.save(new Author(name,surname,country)));
    }
    @Transactional
    @Override
    public Optional<Author> edit(Long id, String name, String surname, Long countryId) {
        Author author=this.authorRepository.findById(id).orElseThrow(()-> new AuthorNotFound(id));
        author.setName(name);
        author.setSurname(surname);
        Country country = this.countryRepository.findById(countryId)
                .orElseThrow(() -> new CountryNotFound(countryId));
        author.setCountry(country);
        return Optional.of(author);
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }
}
