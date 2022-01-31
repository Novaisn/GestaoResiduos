package Modelo;

import java.io.Serializable;

public class Gestor extends Utilizador implements Serializable {
    private int idGestor;


    public Gestor(String nome, String nCC, String Nif, String telefone, String morada, String localidade, String pass,  String UserName) {
        super(nome, nCC, Nif, telefone, morada, localidade, pass, UserName);

    }

    public int getIdGestor() {
        return idGestor;
    }

    public void setIdGestor(int idGestor) {
        this.idGestor = idGestor;
    }

    public String toString(){
        return " "+getNome();
    }
}
