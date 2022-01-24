package Repositorio;

import Modelo.Admin;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class RepositorioAdmin implements Serializable {
    private static RepositorioAdmin _repoAdmin = null;

        private int nextIdAdmin = 0;
        private Map<Integer, Admin> adminMap;


    public Map<Integer, Admin> getAdminMap() {
        return adminMap;
    }

    private RepositorioAdmin(){
        adminMap = new HashMap<>();

    }

    public int getNextIdAdmin() {
        return nextIdAdmin;
    }

    public void setNextIdAdmin(int nextIdAdmin) {
        this.nextIdAdmin = nextIdAdmin;
    }

    public static RepositorioAdmin getRepositorioAdmin(){

        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        if (_repoAdmin == null)
            _repoAdmin = new RepositorioAdmin();
        lock.unlock();

        return _repoAdmin;
    }


    public static void serializarAdmin(){
        try{
            FileOutputStream fileOut = new FileOutputStream("Admin.repo");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(_repoAdmin);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in repo");
        } catch(IOException ex){
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    public static void desserializar(String filename){

        try{
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            _repoAdmin = (RepositorioAdmin) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException ex){
            System.out.println("Erro: " + ex.getMessage());
        } catch(ClassNotFoundException ex){
            System.out.println("Repositorio class not found. " + ex.getMessage());
        }
    }

}

