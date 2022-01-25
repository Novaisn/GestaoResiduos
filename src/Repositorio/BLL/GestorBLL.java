package Repositorio.BLL;


import Modelo.Gestor;

import Repositorio.RepositorioGestor;
import Repositorio.Repositorio;
public class GestorBLL {
    public static int getNextIdGestor(){
        int nextID = Repositorio.getRepositorio().getNextIdGestor();
        Repositorio.getRepositorio().setNextIdGestor(++nextID);
        return nextID;
    }

    public static void criarGestor(Gestor gestor){
        int nextID = getNextIdGestor();
        gestor.setIdGestor(nextID);
        Repositorio.getRepositorio().getGestorMap().put(gestor.getIdGestor(), gestor);
        System.out.println("\nGestor criado com sucesso!!!");
        Repositorio.getRepositorio().serializar();
    }
}
