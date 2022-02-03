package Repositorio.BLL;


import Modelo.Municipio;
import Repositorio.Repositorio;


public class MunicipioBLL {
    public static int getNextIdMunicipio(){
        int nextID = Repositorio.getRepositorio().getNextIdMunicipio();
        Repositorio.getRepositorio().setNextIdMunicipio(++nextID);
        return nextID;
    }

    public static void criarMunicipio(Municipio municipio){
        int nextID = getNextIdMunicipio();
        municipio.setIdMunicipio(nextID);
        Repositorio.getRepositorio().getMunicipioMap().put(municipio.getIdMunicipio(), municipio);
        System.out.println("\nMunicipio criado com sucesso!!!");
        Repositorio.getRepositorio().serializar();
    }
}
