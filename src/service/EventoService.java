package service;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import model.enums.Evento;
import utils.Logger;

public class EventoService {
    private final BlockingQueue<Evento> filaEventos = new LinkedBlockingQueue<>();
    Logger logger = new Logger();

    public void adicionarEvento(Evento evento){
        filaEventos.add(evento);
    }

    public void iniciarProcessamento(){
        Runnable worker = () -> {
            while (true) {
                try {
                    Evento evento = filaEventos.take();
                    processarEvento(evento);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        };
        Thread thread = new Thread(worker);
        thread.start();
    }

    public void processarEvento(Evento evento){
        System.out.println("Iniciando o evento " + evento.toString());
        logger.logInfo(this.getClass().toString(), "processarEvento", "Iniciando o evento "+ evento.toString());
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
