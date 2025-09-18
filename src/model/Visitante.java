package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.enums.DocumentoIdentificacao;

public class Visitante {
    private String nome;
    private HashMap<DocumentoIdentificacao, String> documentoIdentificacao;

    public Visitante(String nome, DocumentoIdentificacao tipoDocumentoIdentificacao, String numeroDocumento) {
        this.nome = nome;
        adicionarDocumentoIdentificacao(tipoDocumentoIdentificacao, numeroDocumento);
    }

    public String getNome() {
        return nome;
    }

    public void adicionarDocumentoIdentificacao(DocumentoIdentificacao tipoDocumento, String numeroDocumento) {
        if (this.documentoIdentificacao == null) {
            this.documentoIdentificacao = new HashMap<>();
        }
        this.documentoIdentificacao.put(tipoDocumento, numeroDocumento);
    }

    public HashMap<DocumentoIdentificacao, String> getDocumentoIdentificacao() {
        return documentoIdentificacao;
    }

    public List<DocumentoIdentificacao> getTipoDocumentoIdentificacao() {
        if (documentoIdentificacao != null && !documentoIdentificacao.isEmpty()) {
            return new ArrayList<>(documentoIdentificacao.keySet());
        }
        return null;
    }

    public List<String> getNumeroDocumento() {
        if (documentoIdentificacao != null && !documentoIdentificacao.isEmpty()) {
            return new ArrayList<>(documentoIdentificacao.values());
        }
        return null;
    }

    
}
