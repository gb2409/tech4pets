package br.com.tech4me.tech4pets.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4pets.model.Pet;
import br.com.tech4me.tech4pets.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetService servico;

    @PostMapping
    public ResponseEntity<Pet> cadastrarPet(@RequestBody Pet pet){
        return new ResponseEntity<>(servico.cadastrarPet(pet), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> obterPets(){
        return new ResponseEntity<>(servico.obterTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> obterPorId(@PathVariable String id){
        Optional<Pet> retorno = servico.obterPorId(id);
        if (retorno.isPresent()){
            return new ResponseEntity<>(retorno.get(), HttpStatus.FOUND);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pet> excluirPet(@PathVariable String id){
        servico.excluirPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
  public ResponseEntity<Pet> atualizarPorId(@PathVariable String id, @RequestBody Pet pet){
    Optional<Pet> retorno = servico.atualizarPorId(id, pet); 

    if (retorno.isPresent()) {
      return new ResponseEntity<>(retorno.get(), HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}

    
}