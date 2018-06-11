/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Raza;


import alvarogarciaworld.Type;
import java.util.ArrayList;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class RazaManager {
    protected String nombre;
    protected boolean enUso;
    protected String fortaleza;
    protected ArrayList<Type> tropasDisponibles;
    protected ArrayList<Type> vehiculosDisponibles;
    protected ArrayList<Type> edificacionesDisponibles;

    public RazaManager(String nombre, boolean enUso, String fortaleza) {
        this.nombre = nombre;
        this.enUso = enUso;
        this.fortaleza = fortaleza;
        
        this.edificacionesDisponibles.add(Type.CENTRODEMANDO);
        this.edificacionesDisponibles.add(Type.CUARTEL);
        this.edificacionesDisponibles.add(Type.EXTRACTORDEZAFIRO);
        this.edificacionesDisponibles.add(Type.HUESERA);
        this.edificacionesDisponibles.add(Type.MINADEDIAMANTE);
        this.edificacionesDisponibles.add(Type.MINADEORO);
        this.edificacionesDisponibles.add(Type.TALLER);
        
        
    }

    

    //GETTER AND SETTER 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEnUso() {
        return enUso;
    }

    public void setEnUso(boolean enUso) {
        this.enUso = enUso;
    }

    public String getFortaleza() {
        return fortaleza;
    }

    public void setFortaleza(String fortaleza) {
        this.fortaleza = fortaleza;
    }
    
    //AGREGANDO RECURSOS
    /**
     * This funtion add a ArmyManager Object in the ArrayList tropasDisponibles
     * @param tropa 
     */
    public void addArmy(Type tropa) {
        this.tropasDisponibles.add(tropa);

    }
    
    /**
     * This funtion add a ArmyManager Object in the ArrayList edificacionesDisponibles
     * @param edificio
     */
    public void addBuilding(Type edificio) {
        this.edificacionesDisponibles.add(edificio);

    }
    
    /**
     * This funtion add a ArmyManager Object in the ArrayList vehiculosDisponibles
     * @param vehiculo
     */
    public void addMachine(Type vehiculo) {
        this.vehiculosDisponibles.add(vehiculo);   
    }
        
/**
 * This
 */
    public void showArmyAvailable() {
        System.out.print("Ejercito disponible: ");
        for (Type tropa : this.tropasDisponibles) {
            System.out.print(tropa.getNombre() + "\t<->\t");
        }
        System.out.print("\n");
    }
    
    public void showBuildingAvailable() {
        System.out.print("Edificios disponible: ");
        for (Type edificio : this.tropasDisponibles) {
            System.out.print(edificio.getNombre() + "\t<->\t");
        }
        System.out.print("\n");        
    }
    
    public void showMachinesAvailable() {
        System.out.print("Ejercito disponible: ");
        for (Type vehiculo : this.tropasDisponibles) {
            System.out.print(vehiculo.getNombre() + "\t<->\t");
        }
        System.out.print("\n");
    }

    
    
    
}
