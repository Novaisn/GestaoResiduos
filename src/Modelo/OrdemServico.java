package Modelo;

import java.io.Serializable;
import java.util.Date;

public class OrdemServico implements Serializable {
    private int idOrdem;
    private Date data;
    private String descricao;
    private ParqueContentores parqueContentores;

    public OrdemServico(Date data, String descricao, ParqueContentores parqueContentores) {
        this.data = data;
        this.descricao = descricao;
        this.parqueContentores = parqueContentores;
    }

    public int getIdOrdem() {
        return idOrdem;
    }

    public void setIdOrdem(int idOrdem) {
        this.idOrdem = idOrdem;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ParqueContentores getParqueContentores() {
        return parqueContentores;
    }

    public void setParqueContentores(ParqueContentores parqueContentores) {
        this.parqueContentores = parqueContentores;
    }
}
