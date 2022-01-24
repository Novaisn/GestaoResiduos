package Repositorio.BLL;

import Modelo.Admin;
import Modelo.Municipio;
import Repositorio.RepositorioAdmin;
import Repositorio.RepositorioMunicipio;

public class MunicipioBLL {
    public static int getNextIdMunicipio(){
        int nextID = RepositorioMunicipio.getRepositorioMunicipio().getNextIdMunicipio();
        RepositorioMunicipio.getRepositorioMunicipio().setNextIdMunicipio(++nextID);
        return nextID;
    }

    public static void criarMunicipio(Municipio municipio){
        int nextID = getNextIdMunicipio();
        municipio.setIdMunicipio(nextID);
        RepositorioMunicipio.getRepositorioMunicipio().getMunicipioMap().put(municipio.getIdMunicipio(), municipio);
        System.out.println("\nMunicipio criado com sucesso!!!");
        RepositorioMunicipio.getRepositorioMunicipio().serializarMunicipio();
    }
}
