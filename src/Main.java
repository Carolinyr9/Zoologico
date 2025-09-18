import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

import model.Animal;
import model.Bilheteria;
import model.Recinto;
import model.Tratador;
import model.Visitante;
import model.enums.Dieta;
import model.enums.DocumentoIdentificacao;
import model.enums.EstadoSaude;
import model.enums.Evento;
import model.enums.StatusConservacao;
import service.AnimalService;
import service.BilheteriaService;
import service.EventoService;
import service.RecintoService;
import service.TratadorService;
import service.VisitanteService;

public class Main {
    public static void main(String[] args) {
        AnimalService animalService = new AnimalService();
        BilheteriaService bilheteriaService = new BilheteriaService();
        EventoService eventoService = new EventoService();
        RecintoService recintoService = new RecintoService();
        TratadorService tratadorService = new TratadorService();
        VisitanteService visitanteService = new VisitanteService();

        Animal animal = animalService.cadastrarAnimal("Nyx", "Elefante", 2, Dieta.HERBIVORO, StatusConservacao.MENOR_RISCO, EstadoSaude.SAUDAVEL);
        Animal animal2 = animalService.cadastrarAnimal("Batata", "Arara azul", 4, Dieta.HERBIVORO, StatusConservacao.VULNERAVEL, EstadoSaude.FERIDO);
        Tratador tratador = tratadorService.cadastrarTratador("João", (int) Math.random());
        Recinto recinto = recintoService.cadastrarRecinto(2);
        recintoService.adicionarAnimalAoRecinto(recinto.getNumero(), animal);
        tratadorService.atribuirAnimal(animal, tratador.getNumeroCadastro());
        tratadorService.atribuirAnimal(animal2, tratador.getNumeroCadastro());
        Visitante visitante = visitanteService.adicionarVisitante("Carol", DocumentoIdentificacao.CPF, "528.462.598-60");
        Bilheteria bilheteria = bilheteriaService.cadastrarEvento("Visita Divertida", Evento.VISITA_GUIADA, 99.00, 1000, LocalDateTime.of(2025, 10, 10, 11, 30, 01));
        try {
            Runnable tarefa = tratadorService.checarSaudeAnimais(tratador.getNumeroCadastro());
            tarefa.run();
            Runnable tarefa2 = tratadorService.alimentarAnimais(tratador.getNumeroCadastro());
            tarefa2.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tratadorService.mudarEstadoSaudeAnimal(tratador.getNumeroCadastro(), animal2, EstadoSaude.OBSERVACAO);
        bilheteriaService.venderIngresso(bilheteria.getNome(), visitante);
        System.out.println((bilheteriaService.buscarEventoPorNome(bilheteria.getNome())).toString());
        

    }
}
