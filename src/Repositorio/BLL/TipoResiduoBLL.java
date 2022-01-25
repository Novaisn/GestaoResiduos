package Repositorio.BLL;

import Modelo.Admin;
import Modelo.TipoResiduos;
import Repositorio.Repositorio;
import Repositorio.RepositorioTipoResiduo;

public class TipoResiduoBLL {
    public static int getNextIdTipoResiduo(){
        int nextID = Repositorio.getRepositorio().getNextIdTipoResiduo();
        Repositorio.getRepositorio().setNextIdTipoResiduo(++nextID);
        return nextID;
    }

    public static void criarTipoResiduo(TipoResiduos tipoResiduos){
        int nextID = getNextIdTipoResiduo();
        tipoResiduos.setIdTipoResiduo(nextID);
        Repositorio.getRepositorio().getTipoResiduosMap().put(tipoResiduos.getIdTipoResiduo(), tipoResiduos);
        System.out.println("\nTipo residuo criado com sucesso!!!");
        Repositorio.getRepositorio().serializar();
    }
}
