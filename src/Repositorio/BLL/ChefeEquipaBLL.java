package Repositorio.BLL;


import Modelo.ChefeEquipa;

import Repositorio.RepositorioChefeEquipa;

import Repositorio.Repositorio;

public class ChefeEquipaBLL {
    public static int getNextIdChefeEquipa(){
        int nextID = Repositorio.getRepositorio().getNextIdChefe();
        Repositorio.getRepositorio().setNextIdChefe(++nextID);
        return nextID;
    }

    public static void criarChefe(ChefeEquipa chefeEquipa){
        int nextID = getNextIdChefeEquipa();
        chefeEquipa.setIdChefeEquipa(nextID);
        Repositorio.getRepositorio().getEquipaMap().put(chefeEquipa.getIdChefeEquipa(), chefeEquipa);
        System.out.println("\nChefe criado com sucesso!!!");
        Repositorio.getRepositorio().serializar();
    }
}
