package Repositorio.BLL;

import Modelo.Gestor;
import Modelo.OrdemServico;
import Repositorio.Repositorio;

public class OrdemServicoBLL {
    public static int getNextIdOrdem(){
        int nextID = Repositorio.getRepositorio().getNextIdOrdem();
        Repositorio.getRepositorio().setNextIdOrdem(++nextID);
        return nextID;
    }

    public static void criarOrdem(OrdemServico ordem){
        int nextID = getNextIdOrdem();
        ordem.setIdOrdem(nextID);
        Repositorio.getRepositorio().getOrdemServicoMap().put(ordem.getIdOrdem(), ordem);
        System.out.println("\nOrdem criada com sucesso!!!");
        Repositorio.getRepositorio().serializar();
    }
}
