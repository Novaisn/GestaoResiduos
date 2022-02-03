package Repositorio.BLL;


import Modelo.Trabalhador;
import Repositorio.Repositorio;


public class TrabalhadorBLL {
    public static int getNextIdTrabalhador(){
        int nextID = Repositorio.getRepositorio().getNextIdTrabalhador();
        Repositorio.getRepositorio().setNextIdTrabalhador(++nextID);
        return nextID;
    }

    public static void criarTrabalhador(Trabalhador trabalhador){
        int nextID = getNextIdTrabalhador();
        trabalhador.setIdTrabalhador(nextID);
        Repositorio.getRepositorio().getTrabalhadorMap().put(trabalhador.getIdTrabalhador(), trabalhador);
        System.out.println("\nTrabalhador criado com sucesso!!!");
        Repositorio.getRepositorio().serializar();
    }
}
