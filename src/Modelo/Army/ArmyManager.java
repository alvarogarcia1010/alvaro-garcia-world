
package Modelo.Army;

import alvarogarciaworld.Type;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class ArmyManager{
    
    protected String nombre;
    protected Type tipo;
    protected int vida;
    protected int damage;
    protected int waitTime;
    protected int creationFase;
    protected boolean isEnable;
    protected TreeMap<Type, Integer> cost;

    public ArmyManager(String nombre, Type tipo, int vida, int damage, int waitTime, int creationFase, boolean isEnable) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.vida = vida;
        this.damage = damage;
        this.waitTime = waitTime;
        this.creationFase = creationFase;
        this.isEnable = isEnable;
        this.cost = new TreeMap<>();
    }
    
    

    //GETTER AND SETTER
    public String getNombre() {
        return nombre;
    }
        
    public void setNombre(String nombre) {    
        this.nombre = nombre;
    }

    public Type getTipo() {
        return tipo;
    }

    public void setTipo(Type tipo) {
        this.tipo = tipo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public int getCreationFase() {
        return creationFase;
    }

    public void setCreationFase(int creationFase) {
        this.creationFase = creationFase;
    }

    public boolean isIsEnable() {
        return isEnable;
    }

    public void setIsEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }

    public TreeMap<Type, Integer> getCost() {
        return cost;
    }
    
    
    public void addCost(Type recurso, int cost){
        this.cost.put(recurso, cost);
    }
    
 
    public void viewCost() {
        for (Map.Entry <Type, Integer> recurso : this.cost.entrySet()) {
            System.out.println(recurso.getKey() + "  ->  " + recurso.getValue());
        }
    }
    
     //CONSTRUCTOR BUILDER
    
}
