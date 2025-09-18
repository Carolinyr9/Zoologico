package service;

import java.util.HashMap;
import java.util.Map;

import exceptions.ResourceNotFoundException;
import model.Animal;
import model.Recinto;
import utils.Logger;

public class RecintoService {
    private Map<Integer, Recinto> recintos = new HashMap<>();
    Logger logger = new Logger();
    
    public Recinto cadastrarRecinto(Integer capacidadeMaxima) {
        Recinto recinto = new Recinto(capacidadeMaxima);
        recintos.put(recinto.getNumero(), recinto);
        return recinto;
    }

    public void listarRecintos() {
        if (recintos.isEmpty()) {
            System.out.println("Nenhum recinto cadastrado.");
            logger.logInfo(this.getClass().toString(), "listarRecintos", "Nenhum recinto cadastrado.");
            return;
        }

        for (Recinto recinto : recintos.values()) {
           recinto.toString();
        }

        logger.logInfo(this.getClass().toString(), "listarRecintos", "Recintos listados com sucesso.");
    }

    public Recinto buscarRecinto(Integer id) {
        try {
            return recintos.get(id);
        } catch (Exception e) {
            logger.logError(this.getClass().toString(), "buscarRecintos", "Recinto com ID " + id + " não encontrado.");
            throw new ResourceNotFoundException("Recinto com ID " + id + " não encontrado.");
        }
    }

    public void adicionarAnimalAoRecinto(Integer numeroRecinto, Animal animal) {
        try {
            Recinto recinto = buscarRecinto(numeroRecinto);
            recinto.adicionarAnimal(animal);
            logger.logInfo(this.getClass().toString(), "adicionarAnimalAoRecintos", "Animal " + animal.getNome() + "adicionado ao recinto " + numeroRecinto + " com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.logError(this.getClass().toString(), "adicionarAnimalAoRecinto", e.getMessage());
        }
    }

    public void removerAnimalDoRecinto(Integer numeroRecinto, Animal animal) {
        try {
            Recinto recinto = buscarRecinto(numeroRecinto);
            recinto.removerAnimal(animal);
            logger.logInfo(this.getClass().toString(), "removerAnimalDoRecintos", "Animal " + animal.getNome() + "removido ao recinto " + numeroRecinto + " com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.logError(this.getClass().toString(), "removerAnimalDoRecinto", e.getMessage());
        }
    }

    public void removerRecinto(Integer id) {
        if (recintos.containsKey(id)) {
            recintos.remove(id);
            System.out.println("Recinto com ID " + id + " removido com sucesso.");
            logger.logInfo(this.getClass().toString(), "removerRecinto", "Recinto " + id + " removido com sucesso.");
        } else {
            logger.logError(this.getClass().toString(), "removerRecinto", "Recinto com ID " + id + " não encontrado.");
            throw new ResourceNotFoundException("Recinto com ID " + id + " não encontrado.");
        }
    }

    public Map<Integer, Recinto> retornaRecintos(){
        return this.recintos;
    }
    
}
