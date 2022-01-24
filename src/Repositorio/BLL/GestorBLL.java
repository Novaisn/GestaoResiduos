package Repositorio.BLL;


import Modelo.Gestor;

import Repositorio.RepositorioGestor;

public class GestorBLL {
    public static int getNextIdGestor(){
        int nextID = RepositorioGestor.getRepositorioGestor().getNextIdGestor();
        RepositorioGestor.getRepositorioGestor().setNextIdGestor(++nextID);
        return nextID;
    }

    public static void criarGestor(Gestor gestor){
        int nextID = getNextIdGestor();
        gestor.setIdGestor(nextID);
        RepositorioGestor.getRepositorioGestor().getGestorMap().put(gestor.getIdGestor(), gestor);
        System.out.println("\nGestor criado com sucesso!!!");
        RepositorioGestor.getRepositorioGestor().serializarGestor();
    }
}
