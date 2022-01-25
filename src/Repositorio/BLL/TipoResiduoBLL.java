package Repositorio.BLL;

import Modelo.Admin;
import Modelo.TipoResiduos;
import Repositorio.RepositorioAdmin;
import Repositorio.RepositorioTipoResiduo;

public class TipoResiduoBLL {
    public static int getNextIdTipoResiduo(){
        int nextID = RepositorioTipoResiduo.getRepositorioTipoResiduo().getNextIdTipoResiduo();
        RepositorioTipoResiduo.getRepositorioTipoResiduo().setNextIdTipoResiduo(++nextID);
        return nextID;
    }

    public static void criarTipoResiduo(TipoResiduos tipoResiduos){
        int nextID = getNextIdTipoResiduo();
        tipoResiduos.setIdTipoResiduo(nextID);
        RepositorioTipoResiduo.getRepositorioTipoResiduo().getTipoResiduosMap().put(tipoResiduos.getIdTipoResiduo(), tipoResiduos);
        System.out.println("\nTipo residuo criado com sucesso!!!");
        RepositorioTipoResiduo.getRepositorioTipoResiduo().serializarTipoResiduo();
    }
}
