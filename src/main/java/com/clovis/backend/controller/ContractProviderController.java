package com.clovis.backend.controller;

import com.clovis.backend.model.ContractProvider;
import com.clovis.backend.repository.ContractProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/contractprovider")
@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")

public class ContractProviderController {

    @Autowired
    private ContractProviderRepository contractProviderRepository;

    @GetMapping
    public ResponseEntity<List<ContractProvider>> findAll(){
        return new ResponseEntity<List<ContractProvider>>((List<ContractProvider>)this.contractProviderRepository.findAll(),new HttpHeaders(),HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ContractProvider> findById(@PathVariable("id") long id){
        if(this.contractProviderRepository.findById(id).isPresent()){
            return new ResponseEntity<ContractProvider>(this.contractProviderRepository.findById(id).get(),new HttpHeaders(),HttpStatus.OK);
        }
        return new ResponseEntity<ContractProvider>(new HttpHeaders(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContractProvider> save(@RequestBody ContractProvider contractProvider){
        System.out.println("Chegou na API " + contractProvider);
        return new ResponseEntity<ContractProvider>(this.contractProviderRepository.save(contractProvider),new HttpHeaders(),HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ContractProvider> update(@PathVariable("id") long id, @RequestBody ContractProvider contractProvider) throws Exception{
        if(id == 0 || !this.contractProviderRepository.existsById(id)){
            throw new Exception("Codigo não encontrado ou inexistente");
        }
        return new ResponseEntity<ContractProvider>(this.contractProviderRepository.save(contractProvider),new HttpHeaders(),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ContractProvider> delete (@PathVariable("id") long id){
        this.contractProviderRepository.deleteById(id);
        return new ResponseEntity<ContractProvider>(new HttpHeaders(),HttpStatus.OK);
    }

}
