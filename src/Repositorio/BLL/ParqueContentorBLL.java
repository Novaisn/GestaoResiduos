package Repositorio.BLL;


import Modelo.ParqueContentores;
import Repositorio.RepositorioParqueContentores;

public class ParqueContentorBLL {
    public static int getNextIdParqueContentor(){
        int nextID = RepositorioParqueContentores.getRepositorioParqueContentores().getNextIdParque();
        RepositorioParqueContentores.getRepositorioParqueContentores().setNextIdParque(++nextID);
        return nextID;
    }

    public static void criarParque(ParqueContentores parqueContentores){
        int nextID = getNextIdParqueContentor();
        parqueContentores.setIdParqueContentor(nextID);
        RepositorioParqueContentores.getRepositorioParqueContentores().getParqueContentoresMap().put(parqueContentores.getIdParqueContentor(), parqueContentores);
        System.out.println("\nParque criado com sucesso!!!");
        RepositorioParqueContentores.getRepositorioParqueContentores().serializarParquesContentores();
    }
}
