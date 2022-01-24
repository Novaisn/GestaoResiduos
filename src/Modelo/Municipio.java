package Modelo;

import java.io.Serializable;

public class Municipio extends Utilizador implements Serializable {
    private int idMunicipio;

    public Municipio(String nome, String nCC, String Nif, String telefone, String morada, String localidade, String pass,String UserName) {
        super(nome, nCC, Nif, telefone, morada, localidade, pass, UserName);
        ;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }
}
