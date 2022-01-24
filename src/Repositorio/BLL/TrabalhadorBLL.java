package Repositorio.BLL;

import Modelo.Admin;
import Modelo.Trabalhador;
import Repositorio.RepositorioAdmin;
import Repositorio.RepositorioTrabalhador;

public class TrabalhadorBLL {
    public static int getNextIdTrabalhador(){
        int nextID = RepositorioTrabalhador.getRepositorioTrabalhador().getNextIdTrabalhador();
        RepositorioTrabalhador.getRepositorioTrabalhador().setNextIdTrabalhador(++nextID);
        return nextID;
    }

    public static void criarTrabalhador(Trabalhador trabalhador){
        int nextID = getNextIdTrabalhador();
        trabalhador.setIdTrabalhador(nextID);
        RepositorioTrabalhador.getRepositorioTrabalhador().getTrabalhadorMap().put(trabalhador.getIdTrabalhador(), trabalhador);
        System.out.println("\nTrabalhador criado com sucesso!!!");
        RepositorioTrabalhador.getRepositorioTrabalhador().serializarTrabalhador();
    }
}
