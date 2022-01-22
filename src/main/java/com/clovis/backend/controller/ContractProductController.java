package com.clovis.backend.controller;

import com.clovis.backend.model.ContractProduct;
import com.clovis.backend.repository.ContractProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/contractproduct")
@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")

public class ContractProductController {

    @Autowired
    private ContractProductRepository contractProductRepository;

    @GetMapping
    public ResponseEntity<List<ContractProduct>> findAll(){
        return new ResponseEntity<List<ContractProduct>>((List<ContractProduct>)this.contractProductRepository.findAll(),new HttpHeaders(),HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ContractProduct> findById(@PathVariable("id") long id){
        if(this.contractProductRepository.findById(id).isPresent()){
            return new ResponseEntity<ContractProduct>(this.contractProductRepository.findById(id).get(),new HttpHeaders(),HttpStatus.OK);
        }
        return new ResponseEntity<ContractProduct>(new HttpHeaders(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContractProduct> save(@RequestBody ContractProduct contractProduct){
        System.out.println("Chegou na API " + contractProduct);
        return new ResponseEntity<ContractProduct>(this.contractProductRepository.save(contractProduct),new HttpHeaders(),HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ContractProduct> update(@PathVariable("id") long id, @RequestBody ContractProduct contractProduct) throws Exception{
        if(id == 0 || !this.contractProductRepository.existsById(id)){
            throw new Exception("Codigo não encontrado ou inexistente");
        }
        return new ResponseEntity<ContractProduct>(this.contractProductRepository.save(contractProduct),new HttpHeaders(),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ContractProduct> delete (@PathVariable("id") long id){
        this.contractProductRepository.deleteById(id);
        return new ResponseEntity<ContractProduct>(new HttpHeaders(),HttpStatus.OK);
    }
}
