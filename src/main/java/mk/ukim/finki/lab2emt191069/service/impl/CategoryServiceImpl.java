package mk.ukim.finki.lab2emt191069.service.impl;

import mk.ukim.finki.lab2emt191069.model.Category;
import mk.ukim.finki.lab2emt191069.repository.CategoryRepository;
import mk.ukim.finki.lab2emt191069.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(String name, String description) {
        if (name==null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Category c = new Category(name,description);
        categoryRepository.save(c);
        return c;
    }

    @Override
    public Category update(String name, String description) {
        if (name==null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Category c= new Category(name,description);
        categoryRepository.save(c);
        return c;
    }

    @Override
    public void delete(String name) {
        if (name==null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        categoryRepository.deleteByName(name);
    }

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> searchCategories(String searchText) {
        return categoryRepository.findAllByNameLike(searchText);
    }
}
