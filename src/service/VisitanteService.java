package service;

import java.util.ArrayList;
import java.util.List;

import exceptions.ResourceNotFoundException;
import model.Visitante;
import model.enums.DocumentoIdentificacao;

public class VisitanteService {
    private List<Visitante> visitantes = new ArrayList<>();

    public Visitante adicionarVisitante(String nome, DocumentoIdentificacao tipoDocumentoIdentificacao, String numeroDocumento){
        Visitante visitante = new Visitante(nome, tipoDocumentoIdentificacao, numeroDocumento);
        visitantes.add(visitante);
        return visitante;
    }
    
    public Visitante buscarVisitante(String numeroDocumento){
        for (Visitante visitante : visitantes) {
            List<String> documentos = visitante.getNumeroDocumento();
            for (String documento : documentos) {
                if(documento.equals(numeroDocumento)){
                    return visitante;
                }
            }
        }
        throw new ResourceNotFoundException("Nenhum visitante encontrado com o documento " + numeroDocumento);
    }

    public void adicionarDocumentoIdentificacao(DocumentoIdentificacao tipoDocumentoIdentificacao, String numeroDocumento, String numeroNovo){
        Visitante visitante = buscarVisitante(numeroDocumento);
        visitante.adicionarDocumentoIdentificacao(tipoDocumentoIdentificacao, numeroNovo);
    }

    public List<Visitante> retorVisitantes(){
        return this.visitantes;
    }

}