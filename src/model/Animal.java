package model;
import model.enums.Dieta;
import model.enums.EstadoSaude;
import model.enums.StatusConservacao;

public class Animal {
    private String nome;
    private String especie;
    private Integer idade;
    private Dieta dieta;
    private StatusConservacao statusDeConservacao;
    private Integer id;
    private EstadoSaude estadoSaude;

    public Animal(String nome, String especie, Integer idade, Dieta dieta, StatusConservacao statusDeConservacao, EstadoSaude estadoSaude) {
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.dieta = dieta;
        this.statusDeConservacao = statusDeConservacao;
        this.id = java.util.concurrent.ThreadLocalRandom.current().nextInt(1, 10000);
        this.estadoSaude = estadoSaude;
    }

    public String getNome() {
        return nome;
    }   

    public String getEspecie() {
        return especie;
    }

    public Integer getIdade() {
        return idade;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public StatusConservacao getStatusDeConservacao() {
        return statusDeConservacao;
    }

    public Integer getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    public void setStatusDeConservacao(StatusConservacao statusDeConservacao) {
        this.statusDeConservacao = statusDeConservacao;
    }
    
    public EstadoSaude getEstadoSaude() {
        return estadoSaude;
    }

    public void setEstadoSaude(EstadoSaude estadoSaude) {
        this.estadoSaude = estadoSaude;
    }

    public int hashCode() {
        return id != null ? id.hashCode() : 1;
    }

    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Animal animal = (Animal) obj;
        return id != null ? id.equals(animal.id) : animal.id == null;
    }
 
    public String toString() {
        return "Animal{" +
                "nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", idade=" + idade +
                ", dieta=" + dieta +
                ", statusDeConservacao='" + statusDeConservacao + '\'' +
                ", id=" + id +
                '}';
    }
}
