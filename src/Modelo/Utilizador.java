package Modelo;

import java.io.*;

public class Utilizador implements Serializable{
    private String nome;
    private String nCC;
    private String Nif;
    private String telefone;
    private String morada;
    private String localidade;
    private String UserName;
    private String pass;


    public Utilizador(String nome, String nCC, String Nif, String telefone, String morada,String localidade, String pass, String UserName) {
        this.nome = nome;
        this.nCC = nCC;
        this.Nif = Nif;
        this.telefone = telefone;
        this.morada = morada;
        this.localidade = localidade;
        this.pass = pass;
        this.UserName = UserName;
    }
    public Utilizador(){

    }





    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getnCC() {
        return nCC;
    }

    public void setnCC(String nCC) {
        this.nCC = nCC;
    }

    public String getNif() {
        return Nif;
    }

    public void setNif(String nif) {
        Nif = nif;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
