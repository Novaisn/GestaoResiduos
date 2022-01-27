package Modelo;

public class Contentor {
    private int idContentor;
    private TipoResiduos tipoResiduo;
    private EstadoContentor estadoContentor;
    private String Anotacao;
    private ParqueContentores parqueContentores;

    public Contentor(int idContentor, TipoResiduos tipoResiduo, EstadoContentor estadoContentor) {
        this.idContentor = idContentor;
        this.tipoResiduo = tipoResiduo;
        this.estadoContentor = estadoContentor;

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
}
