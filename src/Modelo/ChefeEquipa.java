package Modelo;

import java.io.Serializable;

public class ChefeEquipa extends Utilizador implements Serializable {
    private int idChefeEquipa;
    private Equipa equipa;

    public ChefeEquipa(String nome, String nCC, String Nif, String telefone, String morada, String localidade,
                       String pass, String UserName) {
        super(nome, nCC, Nif, telefone, morada, localidade, pass, UserName);


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
}
