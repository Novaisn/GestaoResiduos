package Repositorio;

import Modelo.Admin;
import Modelo.Gestor;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class RepositorioGestor implements Serializable {
    private static RepositorioGestor _repoGestor = null;

    private int nextIdGestor = 0;
    private Map<Integer, Gestor> gestorMap;


    public Map<Integer, Gestor> getGestorMap() {
        return gestorMap;
    }

    private RepositorioGestor(){
        gestorMap = new HashMap<>();

    }

    public int getNextIdGestor() {
        return nextIdGestor;
    }

    public void setNextIdGestor(int nextIdGestor) {
        this.nextIdGestor = nextIdGestor;
    }

    public static RepositorioGestor getRepositorioGestor(){

        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        if (_repoGestor == null)
            _repoGestor = new RepositorioGestor();
        lock.unlock();

        return _repoGestor;
    }


    public static void serializarGestor(){
        try{
            FileOutputStream fileOut = new FileOutputStream("Gestor.repo");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(_repoGestor);
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
            _repoGestor = (RepositorioGestor) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException ex){
            System.out.println("Erro: " + ex.getMessage());
        } catch(ClassNotFoundException ex){
            System.out.println("Repositorio class not found. " + ex.getMessage());
        }
    }
}
