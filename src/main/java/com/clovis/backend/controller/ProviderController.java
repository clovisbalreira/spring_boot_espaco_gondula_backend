package com.clovis.backend.controller;

import com.clovis.backend.model.Provider;
import com.clovis.backend.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/provider")
@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")

public class ProviderController {

    @Autowired
    private ProviderRepository providerRepository;

    @GetMapping
    public ResponseEntity<List<Provider>> findAll(){
        return new ResponseEntity<List<Provider>>((List<Provider>)this.providerRepository.findAll(),new HttpHeaders(),HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Provider> findById(@PathVariable("id") long id){
        if(this.providerRepository.findById(id).isPresent()){
            return new ResponseEntity<Provider>(this.providerRepository.findById(id).get(),new HttpHeaders(),HttpStatus.OK);
        }
        return new ResponseEntity<Provider>(new HttpHeaders(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Provider> save(@RequestBody Provider provider){
        System.out.println("Chegou na API " + provider);
        return new ResponseEntity<Provider>(this.providerRepository.save(provider),new HttpHeaders(),HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Provider> update(@PathVariable("id") long id, @RequestBody Provider provider) throws Exception{
        if(id == 0 || !this.providerRepository.existsById(id)){
            throw new Exception("Codigo não encontrado ou inexistente");
        }
        return new ResponseEntity<Provider>(this.providerRepository.save(provider),new HttpHeaders(),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Provider> delete (@PathVariable("id") long id){
        this.providerRepository.deleteById(id);
        return new ResponseEntity<Provider>(new HttpHeaders(),HttpStatus.OK);
    }
}
