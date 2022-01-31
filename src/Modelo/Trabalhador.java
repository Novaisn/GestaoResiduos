package Modelo;

import java.io.Serializable;

public class Trabalhador implements Serializable {
    private int idTrabalhador;
    private String nome;
    private String NIF;
    private String NSS;
    private String telefone;
    private double salario;
    private Municipio municipio;

    public Trabalhador( String nome, String NIF, String NSS, String telefone, double salario, Municipio municipio) {

        this.nome = nome;
        this.NIF = NIF;
        this.NSS = NSS;
        this.telefone = telefone;
        this.salario = salario;
        this.municipio = municipio;
    }


    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public int getIdTrabalhador() {
        return idTrabalhador;
    }

    public void setIdTrabalhador(int idTrabalhador) {
        this.idTrabalhador = idTrabalhador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNSS() {
        return NSS;
    }

    public void setNSS(String NSS) {
        this.NSS = NSS;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String toString(){
        return " "+getNome();
    }
}
