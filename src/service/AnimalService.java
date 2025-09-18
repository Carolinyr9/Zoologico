package service;

import java.util.HashMap;
import java.util.Map;
import exceptions.AnimalNotFoundException;
import model.Animal;
import model.enums.Dieta;
import model.enums.EstadoSaude;
import model.enums.StatusConservacao;
import utils.Logger;

public class AnimalService {
    private Map<Integer, Animal> animais = new HashMap<>();
    Logger logger = new Logger();

    public Animal cadastrarAnimal(String nome, String especie, Integer idade, Dieta dieta, StatusConservacao statusDeConservacao, EstadoSaude estadoSaude) {
        Animal animal = new Animal(nome, especie, idade, dieta, statusDeConservacao, estadoSaude);
        animais.put(animal.getId(), animal);
        logger.logInfo(this.getClass().toString(), "cadastrarAnimal", "Animal " + nome + " cadastrado com suceso.");
        return animal;
    }

    public Animal buscarAnimal(Integer id) throws AnimalNotFoundException {
        for (Animal animal : animais.values()) {
            if (animal.getId().equals(id)) {
                logger.logInfo(this.getClass().toString(), "buscarAnimal", "Animal com id " + id + " encontrado com suceso.");
                return animal;
            }
        }

        logger.logError(this.getClass().toString(), "buscarAnimal", "Animal com ID " + id + " não encontrado.");
        throw new AnimalNotFoundException("Animal com ID " + id + " não encontrado.");
    }

    public Animal buscarAnimalPorNome(Integer nome) throws AnimalNotFoundException {
        for (Animal animal : animais.values()) {
            if (animal.getNome().equals(nome)) {
                logger.logInfo(this.getClass().toString(), "buscarAnimalPorNome", "Animal com nome " + nome + " encontrado com suceso.");
                return animal;
            }
        }

        logger.logError(this.getClass().toString(), "buscarAnimalPorNome", "Animal com nome " + nome + " não encontrado.");
        throw new AnimalNotFoundException("Animal com nome " + nome + " não encontrado.");
    }

    public void listarAnimais() {
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
            logger.logInfo(this.getClass().toString(), "listarAnimais", "Nenhum animal cadastrado.");
            return;
        }

        for (Animal animal : animais.values()) {
           animal.toString();
        }
    }

    public void listarAnimaisPorDieta(Dieta dieta){
        for(Animal animal : animais.values()){
            if(animal.getDieta() == dieta){
                animal.toString();
            }
        }
    }

    public Map<Integer, Animal> retornaAnimaisCadastrados(){
        return this.animais;
    }

}
