package model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import exceptions.OverCapacityException;
import model.enums.Evento;

public class Bilheteria {
    private String nome;
    private Evento evento;
    private Double precoIngresso;
    private Integer ingressosVendidos;
    private final Integer capacidadeMaxima;
    private LocalDateTime data;
    private List<Visitante> visitantes = new ArrayList<>();

    public Bilheteria(String nome, Evento evento, Double precoIngresso, Integer capacidadeMaxima, LocalDateTime data) {
        this.nome = nome;
        this.evento = evento;
        this.precoIngresso = precoIngresso;
        this.capacidadeMaxima = capacidadeMaxima;
        this.ingressosVendidos = 0;
        this.data = data;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Evento getEvento() {
        return evento;
    }   

    public Double getPrecoIngresso() {
        return precoIngresso;
    }

    public Integer getIngressosVendidos() {
        return ingressosVendidos;
    }

    public Integer getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setPrecoIngresso(Double precoIngresso) {
        this.precoIngresso = precoIngresso;
    }

    public void setData(LocalDateTime data){
        this.data = data;
    }

    public LocalDateTime getData(){
        return data;
    }

    public List<Visitante> getVisitantes() {
        return visitantes;
    }

    public void setVisitantes(List<Visitante> visitantes) {
        this.visitantes = visitantes;
    }

    public boolean venderIngresso(Visitante visitante) throws OverCapacityException{
        if (ingressosVendidos < capacidadeMaxima) {
            this.visitantes.add(visitante);
            ingressosVendidos++;
            return true;
        } else {
            throw new OverCapacityException(evento + " atingiu a capacidade máxima de ingressos.");
        }
    }

    @Override
    public String toString() {
        return "Bilheteria{" +
                "nome='" + nome + '\'' +
                ", evento=" + evento +
                ", precoIngresso=" + precoIngresso +
                ", ingressosVendidos=" + ingressosVendidos +
                ", capacidadeMaxima=" + capacidadeMaxima +
                ", data=" + data +
                ", visitantes=" + visitantes.size() +
                '}';
    }
}
