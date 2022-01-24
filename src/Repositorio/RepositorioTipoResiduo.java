package Repositorio;

import Modelo.Admin;
import Modelo.TipoResiduos;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class RepositorioTipoResiduo implements Serializable {
    private static RepositorioTipoResiduo _repoTipoResiduo = null;

    private int nextIdTipoResiduo = 0;
    private Map<Integer, TipoResiduos> tipoResiduosMap;


    public Map<Integer, TipoResiduos> getTipoResiduosMap() {
        return tipoResiduosMap;
    }

    private RepositorioTipoResiduo(){
        tipoResiduosMap = new HashMap<>();

    }

    public int getNextIdTipoResiduo() {
        return nextIdTipoResiduo;
    }

    public void setNextIdTipoResiduo(int nextIdTipoResiduo) {
        this.nextIdTipoResiduo = nextIdTipoResiduo;
    }

    public static RepositorioTipoResiduo getRepositorioTipoResiduo(){

        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        if (_repoTipoResiduo == null)
            _repoTipoResiduo = new RepositorioTipoResiduo();
        lock.unlock();

        return _repoTipoResiduo;
    }


    public static void serializarTipoResiduo(){
        try{
            FileOutputStream fileOut = new FileOutputStream("TipoResiduo.repo");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(_repoTipoResiduo);
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
            _repoTipoResiduo = (RepositorioTipoResiduo) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException ex){
            System.out.println("Erro: " + ex.getMessage());
        } catch(ClassNotFoundException ex){
            System.out.println("Repositorio class not found. " + ex.getMessage());
        }
    }
}
