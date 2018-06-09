/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Buildings;

import alvarogarciaworld.Type;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class CentroDeMando extends BuildingManager implements BuildingManagementInterface {
    private int nivel;
    private TreeMap<Type, Integer> maxCapacity;
    private static CentroDeMando[] instance = new CentroDeMando[2];


    //CONSTRUCTOR BUILDER
    private CentroDeMando(){
       
    }
    
    //OBTENIENDO SOLO UNA INSTANCIA PARA CADA ALDEA
     /**
     * Create a single instance of Modelo.Building.CentroDeMando class
     *
     * @return CentroDeMando
     */
    public synchronized static CentroDeMando getInstace(int aldea){
        if(aldea == 1){
            if(instance[0] == null){
                instance[0] = new CentroDeMando();
            }
            return instance[0];
        }else if (aldea == 2){
            if(instance[1] == null){
                instance[1] = new CentroDeMando();
            }
            return instance[1];
        }else{
            return null;
        }
        

    }
    
    //METODOS GETTER AND SETTER
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public void addResource(Type recurso, int capacity){
        this.cost.put(recurso, capacity);
    }
 
    public void viewResource() {
        for (Map.Entry <Type, Integer> recurso : this.maxCapacity.entrySet()) {
            System.out.println(recurso.getKey() + "  ->  " + recurso.getValue());
        }
    }
    
    
    public void MejorarCentroDeMando(){
        //Aumentar el nivel en +1
        //Calcular el nuevo porcentaje de almacenamiento
    }

    @Override
    public void destruir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
