/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Aldea;

import Modelo.Army.*;
import Modelo.Buildings.*;
import Modelo.Machines.*;
import Modelo.Raza.*;
import alvarogarciaworld.Type;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class AldeaManager {
    private String nombreJugador;
    private RazaManager razaDisponible;
    private TreeMap<Type, Integer> recursosDisponibles;
    private ArrayList<BuildingManager> edificiosConstruidos;
    private ArrayList<ArmyManager> tropasPreparadas;
    private ArrayList<MachineManager> vehiculosPreparados;
    
    private static final AldeaManager[] instance = new AldeaManager[2];
    
    //Constructor
    private AldeaManager(int aldea){
        
        //Crear Centro de Mando
        CentroDeMando c = CentroDeMando.getInstace(aldea);
        this.edificiosConstruidos.add(0,c);
        
        //Inicializo los valores de los recursos
        this.recursosDisponibles.put(Type.ORO, 1750);
        this.recursosDisponibles.put(Type.DIAMANTES, 1000);
        this.recursosDisponibles.put(Type.ZAFIRO, 3000);
    
    };
    
    
    /**
     * Method getInstance (Singleton)
     * @param aldea
     * @return AldeaManager Instance 
     */
    public synchronized static AldeaManager getInstace(int aldea){
        if(aldea == 1){
            if(instance[0] == null){
                instance[0] = new AldeaManager(aldea);
            }
            return instance[0];
        }else if (aldea == 2){
            if(instance[1] == null){
                instance[1] = new AldeaManager(aldea);
            }
            return instance[1];
        }else{
            return null;
        }
        

    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
    
    
    //Constructor debe inicializar los recursos y crear el centro de mando
    public void entrenarTropa(){
        
    }
    
    public void construirEdificio(){
        
    }
    
    public void crearVehiculo(){
        
    }
    

    
    public void mejorarCentroDemando(int aldea){
        CentroDeMando c = CentroDeMando.getInstace(aldea);
        c.mejorarCentroDeMando();
        
    }
}
