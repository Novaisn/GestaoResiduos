package Repositorio.BLL;

import Modelo.Admin;
import Modelo.ChefeEquipa;
import Modelo.ParqueContentores;
import Repositorio.RepositorioAdmin;
import Repositorio.RepositorioChefeEquipa;
import Repositorio.RepositorioParqueContentores;

public class ChefeEquipaBLL {
    public static int getNextIdChefeEquipa(){
        int nextID = RepositorioChefeEquipa.getRepositorioChefeEquipa().getNextIdChefeEquipa();
        RepositorioChefeEquipa.getRepositorioChefeEquipa().setNextIdChefeEquipa(++nextID);
        return nextID;
    }

    public static void criarChefe(ChefeEquipa chefeEquipa){
        int nextID = getNextIdChefeEquipa();
        chefeEquipa.setIdChefeEquipa(nextID);
        RepositorioChefeEquipa.getRepositorioChefeEquipa().getChefeEquipaMap().put(chefeEquipa.getIdChefeEquipa(), chefeEquipa);
        System.out.println("\nChefe criado com sucesso!!!");
        RepositorioChefeEquipa.getRepositorioChefeEquipa().getRepositorioChefeEquipa().serializarChefeEquipa();
    }
}
