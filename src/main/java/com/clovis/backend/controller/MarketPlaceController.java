package com.clovis.backend.controller;

import com.clovis.backend.model.MarketPlace;
import com.clovis.backend.repository.MarketPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/marketplace")
@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")

public class MarketPlaceController {

    @Autowired
    private MarketPlaceRepository marketPlaceRepository;

    @GetMapping
    public ResponseEntity<List<MarketPlace>> findAll(){
        return new ResponseEntity<List<MarketPlace>>((List<MarketPlace>)this.marketPlaceRepository.findAll(),new HttpHeaders(),HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<MarketPlace> findById(@PathVariable("id") long id){
        if(this.marketPlaceRepository.findById(id).isPresent()){
            return new ResponseEntity<MarketPlace>(this.marketPlaceRepository.findById(id).get(),new HttpHeaders(),HttpStatus.OK);
        }
        return new ResponseEntity<MarketPlace>(new HttpHeaders(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MarketPlace> save(@RequestBody MarketPlace marketPlace){
        System.out.println("Chegou na API " + marketPlace);
        return new ResponseEntity<MarketPlace>(this.marketPlaceRepository.save(marketPlace),new HttpHeaders(),HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MarketPlace> update(@PathVariable("id") long id, @RequestBody MarketPlace marketPlace) throws Exception{
        if(id == 0 || !this.marketPlaceRepository.existsById(id)){
            throw new Exception("Codigo não encontrado ou inexistente");
        }
        return new ResponseEntity<MarketPlace>(this.marketPlaceRepository.save(marketPlace),new HttpHeaders(),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MarketPlace> delete (@PathVariable("id") long id){
        this.marketPlaceRepository.deleteById(id);
        return new ResponseEntity<MarketPlace>(new HttpHeaders(),HttpStatus.OK);
    }
}
