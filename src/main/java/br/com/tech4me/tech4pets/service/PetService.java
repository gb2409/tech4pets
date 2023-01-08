package br.com.tech4me.tech4pets.service;
import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4pets.model.Pet;

public interface PetService {
    List<Pet> obterTodos();
    Optional<Pet> obterPorId(String id);
    void excluirPorId(String id);
    Pet cadastrarPet(Pet pet);
    Optional<Pet> atualizarPorId(String id, Pet pet);
    
}