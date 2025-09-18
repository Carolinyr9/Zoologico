package service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import model.Animal;
import model.Bilheteria;
import model.Tratador;
import model.Visitante;
import model.enums.Dieta;
import model.enums.Evento;
import model.enums.StatusConservacao;

public class RelatorioService {
    AnimalService animalService = new AnimalService();
    BilheteriaService bilheteriaService = new BilheteriaService();
    RecintoService recintoService = new RecintoService();
    TratadorService tratadorService = new TratadorService();
    VisitanteService visitanteService = new VisitanteService();

    public List<Animal> filtrarPorDieta(Dieta dieta){
        Map<Integer, Animal> animais = animalService.retornaAnimaisCadastrados();
        return animais.values().stream()
                    .filter(a -> a.getDieta() == dieta)
                    .toList();
    }

    public List<Animal> filtrarPorStatus(StatusConservacao status){
        Map<Integer, Animal> animais = animalService.retornaAnimaisCadastrados();
        return animais.values().stream()
                    .filter(a -> a.getStatusDeConservacao() == status)
                    .toList();
    }

    public Map<Tratador, List<Animal>> listarAnimaisPorTratador(){
        Map<Integer, Tratador> tratador = tratadorService.retornaTratadores();
        return tratador.values().stream()
                    .collect(Collectors.toMap(
                        t -> t, 
                        Tratador::getAnimaisResponsaveis
                    ));
    }

    public Map<Bilheteria, List<Visitante>> listarVisitantesPorEvento(){
        List<Bilheteria> bilheterias = bilheteriaService.retornaBilheterias();
        return bilheterias.stream()
                    .collect(Collectors.toMap(
                        t -> t,
                        Bilheteria::getVisitantes));
    }

}
