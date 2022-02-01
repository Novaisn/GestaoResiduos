package Modelo;

import java.io.Serializable;
import java.util.List;

public class Equipa  implements Serializable {
    private int idEquipa;
    private String nome;
    private ChefeEquipa chefeEquipa;
    private List<TipoResiduos> residuos;
    private List<Trabalhador> trabalhadores;
    private Municipio municipio;

    public Equipa( String nome, ChefeEquipa chefeEquipa, List<TipoResiduos> residuos, List<Trabalhador> trabalhadores, Municipio municipio) {

        this.nome = nome;
        this.chefeEquipa = chefeEquipa;
        this.residuos = residuos;
        this.trabalhadores = trabalhadores;
        this.municipio = municipio;
    }

    public int getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(int idEquipa) {
        this.idEquipa = idEquipa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ChefeEquipa getChefeEquipa() {
        return chefeEquipa;
    }

    public void setChefeEquipa(ChefeEquipa chefeEquipa) {
        this.chefeEquipa = chefeEquipa;
    }

    public List<TipoResiduos> getResiduos() {
        return residuos;
    }

    public void setResiduos(List<TipoResiduos> residuos) {
        this.residuos = residuos;
    }

    public List<Trabalhador> getTrabalhadores() {
        return trabalhadores;
    }

    public void setTrabalhadores(List<Trabalhador> trabalhadores) {
        this.trabalhadores = trabalhadores;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}
