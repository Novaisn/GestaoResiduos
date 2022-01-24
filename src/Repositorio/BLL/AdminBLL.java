package Repositorio.BLL;

import Modelo.Admin;
import Repositorio.RepositorioAdmin;

public class AdminBLL {
    public static int getNextIdAdmin(){
        int nextID = RepositorioAdmin.getRepositorioAdmin().getNextIdAdmin();
        RepositorioAdmin.getRepositorioAdmin().setNextIdAdmin(++nextID);
        return nextID;
    }

    public static void criarAdmin(Admin admin){
        int nextID = getNextIdAdmin();
        admin.setIdAdmin(nextID);
        RepositorioAdmin.getRepositorioAdmin().getAdminMap().put(admin.getIdAdmin(), admin);
        System.out.println("\nAdmin criado com sucesso!!!");
        RepositorioAdmin.getRepositorioAdmin().serializarAdmin();
    }
}
