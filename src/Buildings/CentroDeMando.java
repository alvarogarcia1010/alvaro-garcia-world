/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buildings;

import alvarogarciaworld.Type;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class CentroDeMando extends BuildingManager {
    private int nivel;
    private TreeMap<Type, Integer> maxCapacity;
    private static final CentroDeMando[] instace = new CentroDeMando[2];


    //CONSTRUCTOR BUILDER
    
    //OBTENIENDO SOLO UNA INSTANCIA PARA CADA ALDEA
    public synchronized static CentroDeMando getInstace(){
//        for(CentroDeMando centro : instace){
//            if(centro = null){
//                centro = new CentroDeMando();
//            }
//        }
        
        return instace[0];
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

    
}
