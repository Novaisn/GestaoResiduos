package Repositorio.BLL;

import Modelo.Admin;

import Repositorio.Repositorio;

public class AdminBLL {
    public static int getNextIdAdmin(){
        int nextID = Repositorio.getRepositorio().getNextIdAdmin();
        Repositorio.getRepositorio().setNextIdAdmin(++nextID);
        return nextID;
    }

    public static void criarAdmin(Admin admin){
        int nextID = getNextIdAdmin();
        admin.setIdAdmin(nextID);
        Repositorio.getRepositorio().getAdminMap().put(admin.getIdAdmin(), admin);
        System.out.println("\nAdmin criado com sucesso!!!");
        Repositorio.getRepositorio().serializar();
    }
}
