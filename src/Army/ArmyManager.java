
package Army;

import alvarogarciaworld.Type;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class ArmyManager{
    
    protected Type tipo;
    protected int vida;
    protected int damage;
    protected int waitTime;
    protected TreeMap<Type, Integer> cost;
    
    //GETTER AND SETTER
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
