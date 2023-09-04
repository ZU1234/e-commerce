package com.ecommercestorefront.controller;

import com.facade.dto.ProductRequest;
import com.facade.dto.ProductResponse;
import com.facade.facade.ProductFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductFacade productFacade;

    public ProductController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getList() {
        return ResponseEntity.ok(getProductFacade().findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody ProductRequest productRequest) {

        getProductFacade().save(productRequest);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    @GetMapping("/code={code}")
    public ResponseEntity<Object> findById(@PathVariable(value = "code") String code) {
        try {
            return ResponseEntity.ok(getProductFacade().findByCode(code));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/deletecode={code}")
    public ResponseEntity<Object> findByIdRemove(@PathVariable(value = "code") String code) {
        try {
            getProductFacade().remove(code);
            return ResponseEntity.ok("başarılı");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/categoryid={categoryId}")
    public ResponseEntity<List<ProductResponse>> findAllByCategoryID(@PathVariable(value = "categoryId") String categoryID) {
        return ResponseEntity.ok(getProductFacade().findAllByCategory(categoryID));
    }

    @GetMapping("/categoryid={categoryId}/size")
    public ResponseEntity<Integer> findCountByCategoryID(@PathVariable(value = "categoryId") String categoryID) {
        return ResponseEntity.ok(getProductFacade().findProductsCountByCategory(categoryID));
    }

    public ProductFacade getProductFacade() {
        return productFacade;
    }
}
