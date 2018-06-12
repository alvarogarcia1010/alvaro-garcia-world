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
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class AldeaManager {
    private String nombreJugador;
    private int faseActual;
    private RazaManager razaDisponible;
    private TreeMap<Type, Integer> recursosDisponibles;
    private ArrayList<BuildingManager> edificiosConstruidos;
    private ArrayList<ArmyManager> tropasPreparadas;
    private ArrayList<MachineManager> vehiculosPreparados;
    
    private static AldeaManager[] instance = new AldeaManager[2];
    
    
    //Constructor
    private AldeaManager(int aldea){
        
        this.edificiosConstruidos = new ArrayList<>();
        this.tropasPreparadas = new ArrayList<>();
        this.vehiculosPreparados = new ArrayList<>();
        this.recursosDisponibles = new TreeMap<>();
        
        //Crear Centro de Mando
        CentroDeMando c = CentroDeMando.getInstance(aldea);
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
    public synchronized static AldeaManager getInstance(int aldea){
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

    public int getFaseActual() {
        return faseActual;
    }

    public void setFaseActual(int faseActual) {
        this.faseActual = faseActual;
    }

    public RazaManager getRazaDisponible() {
        return razaDisponible;
    }

    public void setRazaDisponible(RazaManager razaDisponible) {
        this.razaDisponible = razaDisponible;
    }

    public TreeMap<Type, Integer> getRecursosDisponibles() {
        return recursosDisponibles;
    }

    public ArrayList<BuildingManager> getEdificiosConstruidos() {
        return edificiosConstruidos;
    }

    public ArrayList<ArmyManager> getTropasPreparadas() {
        return tropasPreparadas;
    }

    public ArrayList<MachineManager> getVehiculosPreparados() {
        return vehiculosPreparados;
    }
    
    
    
    
    //Constructor debe inicializar los recursos y crear el centro de mando
    public void entrenarTropa(){
        
    }
    
    public void construirEdificio(){
        
    }
    
    public void crearVehiculo(){
        
    }
    

    
    public void mejorarCentroDemando(int aldea){
        int[] newCost = new int[3];
        int[] available = new int[3];
        int opcion;
        Scanner leer = new Scanner(System.in);
        CentroDeMando c = CentroDeMando.getInstance(aldea);
        
        newCost[0] = (int)((double) c.getMaxCapacity().get(Type.ORO) * 0.25);
        newCost[1] = (int)((double) c.getMaxCapacity().get(Type.DIAMANTES) * 0.25);
        newCost[2] = (int)((double) c.getMaxCapacity().get(Type.ZAFIRO) * 0.25);
        
        available[0] = this.recursosDisponibles.get(Type.ORO);
        available[1] = this.recursosDisponibles.get(Type.DIAMANTES);
        available[2] = this.recursosDisponibles.get(Type.ZAFIRO);
        
        boolean verificacion = (newCost[0] <= available[0] &&
                                newCost[1] <= available[1] &&
                                newCost[0] <= available[2]);
        if(verificacion){
            System.out.println("Costo de mejora del Centro de Mando:");
            System.out.println("Oro: " + newCost[0] + "\t" + "Diamantes: " + newCost[1] + "\t" + "Zafiro: " + newCost[2]);
            
            System.out.println("Desea mejorar: (1. Si <-> 2.No)");
            try{
                opcion = leer.nextInt();
                switch(opcion){
                    case 1:
                        c.mejorarCentroDeMando();
                        this.recursosDisponibles.put(Type.ORO, (available[0]-newCost[0]));
                        this.recursosDisponibles.put(Type.DIAMANTES, (available[1]-newCost[1]));
                        this.recursosDisponibles.put(Type.ZAFIRO, (available[2]-newCost[2]));

                        break;
                    case 2:
                        System.err.println("Mejora cancelada");
                        break;
                    default:
                        System.err.println("Opcion no valida");
                        break;
                }
            }catch(NumberFormatException e) {
                System.err.println("Opcion no valida");
            }
        }else{
            System.err.println("Recursos insuficientes para mejorar el Centro de mando ");
        }
        

    }
    
    public void turno(){
    
    }
}
