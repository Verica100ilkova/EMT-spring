package mk.ukim.finki.lab2emt191069.bootstrap;

import lombok.Getter;
import mk.ukim.finki.lab2emt191069.service.AuthorService;
import mk.ukim.finki.lab2emt191069.service.BookService;
import mk.ukim.finki.lab2emt191069.service.CategoryService;
import mk.ukim.finki.lab2emt191069.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
    @Getter
    public class DataHolder {
        //    private List<Country> countries=new ArrayList<>();
        private final AuthorService authorService;
        private final BookService bookService;
        private final CountryService countryService;
        private final CategoryService categoryService;

        public DataHolder(AuthorService authorService, BookService bookService, CountryService countryService, CategoryService categoryService) {
            this.authorService = authorService;
            this.bookService = bookService;
            this.countryService = countryService;
            this.categoryService = categoryService;
        }

        @PostConstruct
        void initData(){
//        this.countries.add(new Country("b1","europe"));

            this.countryService.save("Macedonia", "Europe");
            this.countryService.save("Germany", "Europe");
            this.countryService.save("Brazil", "South America");
            this.authorService.save("Rick", "Woren", 1l);
            this.authorService.save("Katie", "Lon", 2l);

            this.categoryService.create("NOVEL","NOVEL");
            this.categoryService.create("THRILER","THRILER");
            this.categoryService.create("HISTORY","HISTORY");
            this.categoryService.create("FANTASY","FANTASY");
            this.categoryService.create("BIOGRAPHY","BIOGRAPHY");
            this.categoryService.create("CLASSICS","CLASSICS");
            this.categoryService.create("DRAMA","DRAMA");

            this.bookService.save("Postigni ga celta", 1L,  1l, 10);
            this.bookService.save("Kisses from Kattie",2L, 1l, 10);

        }
}

