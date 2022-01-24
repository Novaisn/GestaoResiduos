package Repositorio;

import Modelo.Admin;
import Modelo.Trabalhador;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class RepositorioTrabalhador implements Serializable {
    private static RepositorioTrabalhador _repoTrabalhador = null;

    private int nextIdTrabalhador = 0;
    private Map<Integer, Trabalhador> trabalhadorMap;


    public Map<Integer, Trabalhador> getTrabalhadorMap() {
        return trabalhadorMap;
    }

    private RepositorioTrabalhador(){
        trabalhadorMap = new HashMap<>();

    }

    public int getNextIdTrabalhador() {
        return nextIdTrabalhador;
    }

    public void setNextIdTrabalhador(int nextIdTrabalhador) {
        this.nextIdTrabalhador = nextIdTrabalhador;
    }

    public static RepositorioTrabalhador getRepositorioTrabalhador(){

        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        if (_repoTrabalhador == null)
            _repoTrabalhador = new RepositorioTrabalhador();
        lock.unlock();

        return _repoTrabalhador;
    }


    public static void serializarTrabalhador(){
        try{
            FileOutputStream fileOut = new FileOutputStream("Trabalhador.repo");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(_repoTrabalhador);
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
            _repoTrabalhador = (RepositorioTrabalhador) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException ex){
            System.out.println("Erro: " + ex.getMessage());
        } catch(ClassNotFoundException ex){
            System.out.println("Repositorio class not found. " + ex.getMessage());
        }
    }
}
