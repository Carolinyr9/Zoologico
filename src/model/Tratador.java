package model;
import java.util.ArrayList;
import java.util.List;

import exceptions.AnimalNotFoundException;
import model.enums.EstadoSaude;
import model.enums.StatusConservacao;

public class Tratador {
    private String nome;
    private Integer numeroCadastro;
    private List<Animal> animaisResponsaveis = new ArrayList<>();

    public Tratador(String nome, Integer numeroCadastro) {
        this.nome = nome;
        this.numeroCadastro = numeroCadastro;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNumeroCadastro() {
        return numeroCadastro;
    }

    public List<Animal> getAnimaisResponsaveis() {
        return animaisResponsaveis;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumeroCadastro(Integer numeroCadastro) {
        this.numeroCadastro = numeroCadastro;
    }

    public void setAnimaisResponsaveis(List<Animal> animaisResponsaveis) {
        this.animaisResponsaveis = animaisResponsaveis;
    }

    public void adicionarAnimalResponsavel(Animal animal){
        this.animaisResponsaveis.add(animal);
    }

    public void removerAnimalResponsavel(Animal animal){
        this.animaisResponsaveis.remove(animal);
    }

    public void alimentarAnimal(Animal animal){
        try {
            verificaAnimalResponsavel(animal);
            System.out.println("O tratador " + this.nome + " está alimentando o animal " + animal.getNome() + ".");
        } catch (AnimalNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    public void limparRecinto(Recinto recinto){
        System.out.println("O tratador " + this.nome + " está limpando o recinto.");
    }

    public void checarSaudeAnimal(Animal animal){
        try {
            if(verificaAnimalResponsavel(animal)){
                System.out.println("O tratador " + this.nome + " está checando a saúde do animal " + animal.getNome() + ".");
                System.out.println("Estado atual: " + animal.getEstadoSaude());
            }
        } catch (AnimalNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    public void mudarEstadoSaudeAnimal(Animal animal, EstadoSaude estadoSaude){
        try{
            if(verificaAnimalResponsavel(animal)){
                animal.setEstadoSaude(estadoSaude);
                System.out.println("O status de conservação do animal " + animal.getNome() + " foi atualizado para " + estadoSaude + " pelo tratador " + this.nome + ".");
            } 
        } catch (AnimalNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    public int hashCode() {
        return numeroCadastro != null ? numeroCadastro.hashCode() : 1;
    }

    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Tratador tratador = (Tratador) obj;
        return numeroCadastro != null ? numeroCadastro.equals(tratador.numeroCadastro) : tratador.numeroCadastro == null;
    }

    private boolean verificaAnimalResponsavel(Animal animal) throws AnimalNotFoundException {
        if (this.animaisResponsaveis != null && this.animaisResponsaveis.contains(animal)) {
            return true;
        } else {
            throw new AnimalNotFoundException(nome + " não é responsável por " + animal.getNome());
        }
    }
}
