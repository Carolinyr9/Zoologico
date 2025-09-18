package model;
import java.util.ArrayList;
import java.util.List;

import exceptions.OverCapacityException;

public class Recinto {
    private final Integer capacidadeMaxima;
    private List<Animal> animais = new ArrayList<>();
    private final Integer numero;

    public Recinto(Integer capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.numero = java.util.concurrent.ThreadLocalRandom.current().nextInt(1, 10000);
    }

    public Integer getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public void adicionarAnimal(Animal animal) throws OverCapacityException{
        if(this.animais.size() < this.capacidadeMaxima){
            this.animais.add(animal);
        } else {
            throw new OverCapacityException("Capacidade máxima do recinto atingida.");
        }
    }

    public void removerAnimal(Animal animal){
        this.animais.remove(animal);
    }

    public Integer getNumero() {
        return numero;
    }

    public boolean isFull(){
        return this.animais.size() >= this.capacidadeMaxima;
    }

    public int hashCode(){
        return numero != null ? numero.hashCode() : 1;
    }

    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Recinto other = (Recinto) obj;
        return numero != null && numero.equals(other.numero);
    }
}
