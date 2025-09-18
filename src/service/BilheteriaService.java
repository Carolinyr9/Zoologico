package service;

import java.util.List;
import utils.Logger;
import exceptions.ResourceNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import model.Bilheteria;
import model.Visitante;
import model.enums.Evento; 

public class BilheteriaService {
    private List<Bilheteria> bilheterias = new ArrayList<>();
    private EventoService eventoService = new EventoService();
    Logger logger = new Logger();

    public Bilheteria cadastrarEvento(String nome, Evento evento, Double precoIngresso, Integer capacidadeMaxima, LocalDateTime data){
        Bilheteria bilheteria = new Bilheteria(nome, evento, precoIngresso, capacidadeMaxima, data);
        this.bilheterias.add(bilheteria);
        eventoService.adicionarEvento(evento);
        return bilheteria;
    }

    public Bilheteria buscarEventoPorNome(String nome){
        for(Bilheteria evento : bilheterias){
            if(evento.getNome().equals(nome)){
                return evento;
            }
        }

        logger.logError(this.getClass().toString(), "buscarEventoPorNome", "Nenhum evento encontrado com o nome: " + nome);
        throw new ResourceNotFoundException("Nenhum evento encontrado com o nome: " + nome);
    }

    public List<Bilheteria> buscarEventoPorData(LocalDateTime data){
        List<Bilheteria> eventos = new ArrayList<>();
        for(Bilheteria evento : bilheterias){
            if(evento.getData().isEqual(data)){
                eventos.add(evento);
            }
        }
        logger.logInfo(this.getClass().toString(), "buscarEventoPorData", "Eventos com data " + data.toString() + " encontrados com sucesso.");
        return eventos;
    }

    public void venderIngresso(String nome, Visitante visitante){
        Bilheteria bilheteria = this.buscarEventoPorNome(nome);
        try {
            bilheteria.venderIngresso(visitante);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Bilheteria> retornaBilheterias(){
        return this.bilheterias;
    }
}
