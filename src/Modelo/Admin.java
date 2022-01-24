package Modelo;

import java.io.Serializable;

public class Admin extends Utilizador implements Serializable {
    private int idAdmin;

    public Admin(String nome, String nCC, String Nif, String telefone, String morada, String localidade, String pass,String userName) {
        super(nome, nCC, Nif, telefone, morada, localidade, pass, userName);

    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
}
