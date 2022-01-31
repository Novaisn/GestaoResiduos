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
    private Municipio municipio;

    public ParqueContentores(String nome,  String morada, String localidade,
                             List<Contentor> contentores, Gestor gestor, Municipio municipio) {
        this.nome = nome;

        this.morada = morada;
        this.localidade = localidade;
        this.contentores = contentores;
        this.gestor = gestor;
        this.municipio = municipio;
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

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public String toString(){
        return " "+getNome();
    }
}
