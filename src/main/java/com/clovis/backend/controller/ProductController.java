package com.clovis.backend.controller;

import com.clovis.backend.model.Product;
import com.clovis.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")

public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return new ResponseEntity<List<Product>>((List<Product>)this.productRepository.findAll(),new HttpHeaders(),HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") long id){
        if(this.productRepository.findById(id).isPresent()){
            return new ResponseEntity<Product>(this.productRepository.findById(id).get(),new HttpHeaders(),HttpStatus.OK);
        }
        return new ResponseEntity<Product>(new HttpHeaders(),HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product){
        System.out.println("Chegou na API " + product);
        return new ResponseEntity<Product>(this.productRepository.save(product),new HttpHeaders(),HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") long id, @RequestBody Product product) throws Exception{
        if(id == 0 || !this.productRepository.existsById(id)){
            throw new Exception("Codigo não encontrado ou inexistente");
        }
        return new ResponseEntity<Product>(this.productRepository.save(product),new HttpHeaders(),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Product> delete (@PathVariable("id") long id){
        this.productRepository.deleteById(id);
        return new ResponseEntity<Product>(new HttpHeaders(),HttpStatus.OK);
    }
}
