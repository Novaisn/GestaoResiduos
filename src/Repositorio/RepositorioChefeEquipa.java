package Repositorio;

import Modelo.Admin;
import Modelo.ChefeEquipa;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class RepositorioChefeEquipa implements Serializable {
    private static RepositorioChefeEquipa _repoChefeEquipa = null;

    private int nextIdChefeEquipa = 0;
    private Map<Integer, ChefeEquipa> chefeEquipaMap;


    public Map<Integer, ChefeEquipa> getChefeEquipaMap() {
        return chefeEquipaMap;
    }

    private RepositorioChefeEquipa(){
        chefeEquipaMap = new HashMap<>();

    }

    public int getNextIdChefeEquipa() {
        return nextIdChefeEquipa;
    }

    public void setNextIdChefeEquipa(int nextIdChefeEquipa) {
        this.nextIdChefeEquipa = nextIdChefeEquipa;
    }

    public static RepositorioChefeEquipa getRepositorioChefeEquipa(){

        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        if (_repoChefeEquipa == null)
            _repoChefeEquipa = new RepositorioChefeEquipa();
        lock.unlock();

        return _repoChefeEquipa;
    }


    public static void serializarChefeEquipa(){
        try{
            FileOutputStream fileOut = new FileOutputStream("ChefeEquipa.repo");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(_repoChefeEquipa);
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
            _repoChefeEquipa = (RepositorioChefeEquipa) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException ex){
            System.out.println("Erro: " + ex.getMessage());
        } catch(ClassNotFoundException ex){
            System.out.println("Repositorio class not found. " + ex.getMessage());
        }
    }
}
