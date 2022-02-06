package Modelo;

import java.io.Serializable;

public class Contentor implements Serializable {
    private int idContentor;
    private TipoResiduos tipoResiduo;
    private EstadoContentor estadoContentor;
    private String Anotacao;
    private ParqueContentores parqueContentores;
    private Municipio municipio;

    public Contentor( TipoResiduos tipoResiduo, EstadoContentor estadoContentor, Municipio municipio) {

        this.tipoResiduo = tipoResiduo;
        this.estadoContentor = estadoContentor;
        this.municipio = municipio;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public String getAnotacao() {
        return Anotacao;
    }

    public void setAnotacao(String anotacao) {
        Anotacao = anotacao;
    }

    public int getIdContentor() {
        return idContentor;
    }

    public void setIdContentor(int idContentor) {
        this.idContentor = idContentor;
    }

    public TipoResiduos getTipoResiduo() {
        return tipoResiduo;
    }

    public void setTipoResiduo(TipoResiduos tipoResiduo) {
        this.tipoResiduo = tipoResiduo;
    }

    public EstadoContentor getEstadoContentor() {
        return estadoContentor;
    }

    public void setEstadoContentor(EstadoContentor estadoContentor) {
        this.estadoContentor = estadoContentor;
    }

    public ParqueContentores getParqueContentores() {
        return parqueContentores;
    }

    public void setParqueContentores(ParqueContentores parqueContentores) {
        this.parqueContentores = parqueContentores;
    }

    public String toString(){

        return " "+getIdContentor()+"-"+getTipoResiduo();
    }
}
