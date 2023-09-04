package com.ecommercestorefront.controller;

import com.core.model.Brand;
import com.facade.facade.BrandFacade;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/brand")
public class BrandController {
    public final BrandFacade brandFacade;

    public BrandController(BrandFacade brandFacade) {
        this.brandFacade = brandFacade;
    }
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Brand brand) {
        try {

            getBrandFacade().save(brand);
            return ResponseEntity.ok("saved");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("hata");
        }
    }

    @GetMapping
    public ResponseEntity<List<Brand>> findAll() {
       return ResponseEntity.ok(getBrandFacade().findAll());
    }

    @GetMapping("/id={id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") String id) {
        try {
            return ResponseEntity.ok(getBrandFacade().findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("hata");
        }
    }

    @GetMapping("/categoryid={categoryID}")
    public ResponseEntity<Object> findAllByCategory(@PathVariable(value = "categoryID") String categoryID){
        return ResponseEntity.ok(getBrandFacade().findAllByCategory(categoryID));
    }
    @GetMapping("/countByCategory/{categoryID}")
    public ResponseEntity<Object> countByCategory(@PathVariable(value = "categoryID") String categoryID){
        return ResponseEntity.ok(getBrandFacade().countByCategory(categoryID));
    }

    public BrandFacade getBrandFacade() {
        return brandFacade;
    }
}
