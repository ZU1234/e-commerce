package com.ecommercestorefront.controller;

import com.core.model.product.category.Category;
import com.facade.facade.CategoryFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryFacade categoryFacade;

    public CategoryController(CategoryFacade categoryFacade) {
        this.categoryFacade = categoryFacade;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(categoryFacade.findAll());
    }

    @PostMapping
    public ResponseEntity<HttpStatus> save(@RequestBody Category category) {
        try {
            categoryFacade.save(category);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e) {
            return  ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id={id}")
    public ResponseEntity<Category> findById(@PathVariable(value = "id") String id) {

       return ResponseEntity.ok(categoryFacade.findById(id));
    }

}
