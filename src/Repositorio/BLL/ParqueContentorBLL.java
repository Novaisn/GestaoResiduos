package Repositorio.BLL;


import Modelo.ParqueContentores;

import Repositorio.Repositorio;

public class ParqueContentorBLL {
    public static int getNextIdParqueContentor(){
        int nextID = Repositorio.getRepositorio().getNextIdParque();
        Repositorio.getRepositorio().setNextIdParque(++nextID);
        return nextID;
    }

    public static void criarParque(ParqueContentores parqueContentores){
        int nextID = getNextIdParqueContentor();
        parqueContentores.setIdParqueContentor(nextID);
        Repositorio.getRepositorio().getParqueMap().put(parqueContentores.getIdParqueContentor(), parqueContentores);
        System.out.println("\nParque criado com sucesso!!!");
        Repositorio.getRepositorio().serializar();
    }
}
