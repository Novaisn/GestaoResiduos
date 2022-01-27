package Repositorio;

import Modelo.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class Repositorio implements Serializable {
    private static Repositorio _repo = null;

    private int nextIdAdmin = 0;
    private Map<Integer, Admin> adminMap;
    private int nextIdChefe = 0;
    private Map<Integer, ChefeEquipa> equipaMap;
    private int nextIdGestor = 0;
    private Map<Integer, Gestor>  gestorMap;
    private int nextIdMunicipio = 0;
    private Map<Integer, Municipio> municipioMap;
    private int nextIdParque = 0;
    private Map<Integer, ParqueContentores> parqueMap;
    private int nextIdTipoResiduo = 0;
    private Map<Integer, TipoResiduos> tipoResiduosMap;
    private int nextIdTrabalhador = 0;
    private Map<Integer, Trabalhador> trabalhadorMap;
    private int nextIdContentor = 0;
    private Map<Integer, Contentor> contentorMap;

    public Map<Integer, Contentor> getContentorMap() {
        return contentorMap;
    }

    public Map<Integer, Admin> getAdminMap() {
        return adminMap;
    }

    public Map<Integer, ChefeEquipa> getEquipaMap() {
        return equipaMap;
    }

    public Map<Integer, Gestor> getGestorMap() {
        return gestorMap;
    }

    public Map<Integer, Municipio> getMunicipioMap() {
        return municipioMap;
    }

    public Map<Integer, ParqueContentores> getParqueMap() {
        return parqueMap;
    }

    public Map<Integer, TipoResiduos> getTipoResiduosMap() {
        return tipoResiduosMap;
    }

    public Map<Integer, Trabalhador> getTrabalhadorMap() {
        return trabalhadorMap;
    }

    private Repositorio(){
        adminMap = new HashMap<>();
        equipaMap = new HashMap<>();
        gestorMap = new HashMap<>();
        municipioMap = new HashMap<>();
        parqueMap = new HashMap<>();
        tipoResiduosMap = new HashMap<>();
        trabalhadorMap = new HashMap<>();
        contentorMap = new HashMap<>();
    }

    public int getNextIdAdmin() {
        return nextIdAdmin;
    }

    public void setNextIdAdmin(int nextIdAdmin) {
        this.nextIdAdmin = nextIdAdmin;
    }

    public int getNextIdChefe() {
        return nextIdChefe;
    }

    public void setNextIdChefe(int nextIdChefe) {
        this.nextIdChefe = nextIdChefe;
    }

    public int getNextIdGestor() {
        return nextIdGestor;
    }

    public void setNextIdGestor(int nextIdGestor) {
        this.nextIdGestor = nextIdGestor;
    }

    public int getNextIdMunicipio() {
        return nextIdMunicipio;
    }

    public void setNextIdMunicipio(int nextIdMunicipio) {
        this.nextIdMunicipio = nextIdMunicipio;
    }

    public int getNextIdParque() {
        return nextIdParque;
    }

    public void setNextIdParque(int nextIdParque) {
        this.nextIdParque = nextIdParque;
    }

    public int getNextIdTipoResiduo() {
        return nextIdTipoResiduo;
    }

    public void setNextIdTipoResiduo(int nextIdTipoResiduo) {
        this.nextIdTipoResiduo = nextIdTipoResiduo;
    }

    public int getNextIdTrabalhador() {
        return nextIdTrabalhador;
    }

    public void setNextIdTrabalhador(int nextIdTrabalhador) {
        this.nextIdTrabalhador = nextIdTrabalhador;
    }

    public int getNextIdContentor() {
        return nextIdContentor;
    }

    public void setNextIdContentor(int nextIdContentor) {
        this.nextIdContentor = nextIdContentor;
    }

    public static Repositorio getRepositorio(){

        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        if (_repo == null)
            _repo = new Repositorio();
        lock.unlock();

        return _repo;
    }


    public static void serializar(){
        try{
            FileOutputStream fileOut = new FileOutputStream("BD.repo");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(_repo);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in repo");
        } catch(IOException ex){
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    public static void desserializar(String filename){

        try{
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            _repo = (Repositorio) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException ex){
            System.out.println("Erro: " + ex.getMessage());
        } catch(ClassNotFoundException ex){
            System.out.println("Repositorio class not found. " + ex.getMessage());
        }
    }
}
