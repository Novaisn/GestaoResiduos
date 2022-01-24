package Modelo;

import java.io.Serializable;
import java.util.List;

public class ParqueContentores implements Serializable {
    private String nome;
    private int idParqueContentor;
    private  String morada;
    private  String localidade;
    private List<Contentor> contentores;
    private Gestor gestor;
    private Equipa equipa;

    public ParqueContentores(String nome, int idParqueContentor, String morada, String localidade,
                             List<Contentor> contentores, Gestor gestor, Equipa equipa) {
        this.nome = nome;
        this.idParqueContentor = idParqueContentor;
        this.morada = morada;
        this.localidade = localidade;
        this.contentores = contentores;
        this.gestor = gestor;
        this.equipa = equipa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdParqueContentor() {
        return idParqueContentor;
    }

    public void setIdParqueContentor(int idParqueContentor) {
        this.idParqueContentor = idParqueContentor;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public List<Contentor> getContentores() {
        return contentores;
    }

    public void setContentores(List<Contentor> contentores) {
        this.contentores = contentores;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    public Equipa getEquipa() {
        return equipa;
    }

    public void setEquipa(Equipa equipa) {
        this.equipa = equipa;
    }
}
