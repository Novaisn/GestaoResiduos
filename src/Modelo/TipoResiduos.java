package Modelo;

import java.io.Serializable;

public class TipoResiduos implements Serializable {
    private String Tiporesiduo;
    private int idTipoResiduo;

    public TipoResiduos(String tiporesiduo) {
        Tiporesiduo = tiporesiduo;
    }

    public String getTiporesiduo() {
        return Tiporesiduo;
    }

    public void setTiporesiduo(String tiporesiduo) {
        Tiporesiduo = tiporesiduo;
    }

    public int getIdTipoResiduo() {
        return idTipoResiduo;
    }

    public void setIdTipoResiduo(int idTipoResiduo) {
        this.idTipoResiduo = idTipoResiduo;
    }
}
