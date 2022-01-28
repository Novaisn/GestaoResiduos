package Modelo;

import java.io.Serializable;
import java.util.List;

public class Equipa  implements Serializable {
    private int idEquipa;
    private String nome;
    private ChefeEquipa chefeEquipa;
    private List<TipoResiduos> residuos;
    private List<Trabalhador> trabalhadores;

    public Equipa( String nome, ChefeEquipa chefeEquipa, List<TipoResiduos> residuos, List<Trabalhador> trabalhadores) {

        this.nome = nome;
        this.chefeEquipa = chefeEquipa;
        this.residuos = residuos;
        this.trabalhadores = trabalhadores;
    }

    public int getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(int idEquipa) {
        this.idEquipa = idEquipa;
    }
}
