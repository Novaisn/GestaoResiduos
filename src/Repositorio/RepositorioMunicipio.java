package Repositorio;

import Modelo.Admin;
import Modelo.Municipio;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class RepositorioMunicipio implements Serializable {
    private static RepositorioMunicipio _repoMunicipio = null;

    private int nextIdMunicipio = 0;
    private Map<Integer, Municipio> municipioMap;


    public Map<Integer, Municipio> getMunicipioMap() {
        return municipioMap;
    }

    private RepositorioMunicipio(){
        municipioMap = new HashMap<>();

    }

    public int getNextIdMunicipio() {
        return nextIdMunicipio;
    }

    public void setNextIdMunicipio(int nextIdMunicipio) {
        this.nextIdMunicipio = nextIdMunicipio;
    }

    public static RepositorioMunicipio getRepositorioMunicipio(){

        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        if (_repoMunicipio == null)
            _repoMunicipio = new RepositorioMunicipio();
        lock.unlock();

        return _repoMunicipio;
    }


    public static void serializarMunicipio(){
        try{
            FileOutputStream fileOut = new FileOutputStream("Municipio.repo");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(_repoMunicipio);
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
            _repoMunicipio = (RepositorioMunicipio) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException ex){
            System.out.println("Erro: " + ex.getMessage());
        } catch(ClassNotFoundException ex){
            System.out.println("Repositorio class not found. " + ex.getMessage());
        }
    }
}
