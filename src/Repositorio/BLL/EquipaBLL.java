package Repositorio.BLL;

import Modelo.Admin;
import Modelo.Equipa;
import Repositorio.Repositorio;

public class EquipaBLL {
    public static int getNextIdEquipa(){
        int nextID = Repositorio.getRepositorio().getNextIdEquipa();
        Repositorio.getRepositorio().setNextIdEquipa(++nextID);
        return nextID;
    }

    public static void criarEquipa(Equipa equipa){
        int nextID = getNextIdEquipa();
        equipa.setIdEquipa(nextID);
        Repositorio.getRepositorio().getEquipatrabalhadoresMap().put(equipa.getIdEquipa(), equipa);
        System.out.println("\nAdmin criado com sucesso!!!");
        Repositorio.getRepositorio().serializar();
    }
}
