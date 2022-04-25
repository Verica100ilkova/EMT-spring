package mk.ukim.finki.lab2emt191069.service.impl;

import mk.ukim.finki.lab2emt191069.exceptions.CountryNotFound;
import mk.ukim.finki.lab2emt191069.model.Country;
import mk.ukim.finki.lab2emt191069.repository.CountryRepository;
import mk.ukim.finki.lab2emt191069.service.CountryService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
        private final CountryRepository countryRepository;

        public CountryServiceImpl(CountryRepository countryRepository) {
            this.countryRepository = countryRepository;
        }

        @Override
        public List<Country> findAll() {
            return this.countryRepository.findAll();
        }

        @Override
        public Optional<Country> findById(Long id) {
            return this.countryRepository.findById(id);
        }

        @Transactional
        @Override
        public Optional<Country> save(String name, String continent) {
            this.countryRepository.deleteByName(name);
            return Optional.of(this.countryRepository.save(new Country(name,continent)));
        }

        @Transactional
        @Override
        public Optional<Country> edit(Long id, String name, String continent) {
            Country country=this.countryRepository.findById(id).orElseThrow(()->new CountryNotFound(id));
            country.setName(name);
            country.setContinent(continent);
            return Optional.of(country);
        }

        @Override
        public void deleteById(Long id) {
         this.countryRepository.deleteById(id);
        }
}

