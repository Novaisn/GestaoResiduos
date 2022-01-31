package Modelo;

import java.io.Serializable;

public class ChefeEquipa extends Utilizador implements Serializable {
    private int idChefeEquipa;
    private Equipa equipa;
    private Municipio municipio;

    public ChefeEquipa(String nome, String nCC, String Nif, String telefone, String morada, String localidade,
                       String pass, String UserName, Municipio municipio) {
        super(nome, nCC, Nif, telefone, morada, localidade, pass, UserName);
        this.municipio = municipio;

    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public int getIdChefeEquipa() {
        return idChefeEquipa;
    }

    public void setIdChefeEquipa(int idChefeEquipa) {
        this.idChefeEquipa = idChefeEquipa;
    }

    public Equipa getEquipa() {
        return equipa;
    }

    public void setEquipa(Equipa equipa) {
        this.equipa = equipa;
    }

    public String toString(){
        return " "+getNome();
    }
}
