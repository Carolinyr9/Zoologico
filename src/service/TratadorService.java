package service;

import java.util.HashMap;
import java.util.Map;

import exceptions.ResourceNotFoundException;
import model.Animal;
import model.Tratador;
import model.enums.EstadoSaude;

public class TratadorService {
    private Map<Integer, Tratador> tratadores = new HashMap<>();

    public Tratador cadastrarTratador(String nome, Integer numeroCadastro){
        Tratador tratador = new Tratador(nome, numeroCadastro);
        tratadores.put(numeroCadastro, tratador);
        return tratador;
    }

    public Tratador buscarTratador(Integer numeroCadastro){
        for (Tratador tratador : tratadores.values()) {
            if(tratador.getNumeroCadastro() == numeroCadastro){
                return tratador;
            }
        }
        
        throw new ResourceNotFoundException("Nenhum tratador encontrado com o número de cadastro: " + numeroCadastro);
    } 

    public void atribuirAnimal(Animal animal, Integer numeroCadastro){
        try {
            Tratador tratador = buscarTratador(numeroCadastro);
            tratador.adicionarAnimalResponsavel(animal);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void removerAnimalResponsavel(Animal animal, Integer numeroCadastro){
        try {
            Tratador tratador = buscarTratador(numeroCadastro);
            tratador.removerAnimalResponsavel(animal);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Runnable alimentarAnimais(Integer numeroCadastro) throws InterruptedException{
        return () -> {
            try {
                Thread.sleep(2000);
                Tratador tratador = buscarTratador(numeroCadastro);
                for (Animal animal :tratador.getAnimaisResponsaveis()) {
                    tratador.alimentarAnimal(animal);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        };
    }

    public Runnable checarSaudeAnimais(Integer numeroCadastro) throws InterruptedException{
        return () -> {
            try {
                Thread.sleep(2000);
                Tratador tratador = buscarTratador(numeroCadastro);
                for (Animal animal :tratador.getAnimaisResponsaveis()) {
                    tratador.checarSaudeAnimal(animal);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        };
    }

    public void mudarEstadoSaudeAnimal(Integer numeroCadastro, Animal animal, EstadoSaude estadoSaude){
        Tratador tratador = buscarTratador(numeroCadastro);
        tratador.mudarEstadoSaudeAnimal(animal, estadoSaude);
    }

    public Map<Integer, Tratador> retornaTratadores(){
        return this.tratadores;
    }
}
