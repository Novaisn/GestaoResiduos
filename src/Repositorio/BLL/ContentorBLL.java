package Repositorio.BLL;


import Modelo.Contentor;
import Repositorio.Repositorio;

public class ContentorBLL {
    public static int getNextIdContentor(){
        int nextID = Repositorio.getRepositorio().getNextIdContentor();
        Repositorio.getRepositorio().setNextIdContentor(++nextID);
        return nextID;
    }

    public static void criarContentor(Contentor contentor){
        int nextID = getNextIdContentor();
        contentor.setIdContentor(nextID);
        Repositorio.getRepositorio().getContentorMap().put(contentor.getIdContentor(), contentor);
        System.out.println("\nContentor criado com sucesso!!!");
        Repositorio.getRepositorio().serializar();
    }
}
