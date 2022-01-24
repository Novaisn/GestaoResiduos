package Repositorio;

import Modelo.Admin;
import Modelo.ParqueContentores;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class RepositorioParqueContentores implements Serializable {
    private static RepositorioParqueContentores _repoParque = null;

    private int nextIdParque = 0;
    private Map<Integer, ParqueContentores> parqueContentoresMap;


    public Map<Integer, ParqueContentores> getParqueContentoresMap() {
        return parqueContentoresMap;
    }

    private RepositorioParqueContentores(){
        parqueContentoresMap = new HashMap<>();

    }

    public int getNextIdParque() {
        return nextIdParque;
    }

    public void setNextIdParque(int nextIdParque) {
        this.nextIdParque = nextIdParque;
    }

    public static RepositorioParqueContentores getRepositorioParqueContentores(){

        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        if (_repoParque == null)
            _repoParque = new RepositorioParqueContentores();
        lock.unlock();

        return _repoParque;
    }


    public static void serializarParquesContentores(){
        try{
            FileOutputStream fileOut = new FileOutputStream("Parques.repo");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(_repoParque);
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
            _repoParque = (RepositorioParqueContentores) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException ex){
            System.out.println("Erro: " + ex.getMessage());
        } catch(ClassNotFoundException ex){
            System.out.println("Repositorio class not found. " + ex.getMessage());
        }
    }
}
