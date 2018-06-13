
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
        super(Type.CENTRODEMANDO.getNombre(),
              Type.CENTRODEMANDO,
              Type.CENTRODEMANDO.getVida(),
              Type.CENTRODEMANDO.getWaitTime(),0,true);
        this.nivel= 0;
        this.maxCapacity = new TreeMap<>();
        this.maxCapacity.put(Type.ORO, 5000);
        this.maxCapacity.put(Type.DIAMANTES, 3000);
        this.maxCapacity.put(Type.ZAFIRO, 10000);
       
    }
    
    //OBTENIENDO SOLO UNA INSTANCIA PARA CADA ALDEA
     /**
     * Create a single instance of Modelo.Building.CentroDeMando class
     *
     * @param aldea
     * @return CentroDeMando
     */
    public static CentroDeMando getInstance(int aldea){
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

    public TreeMap<Type, Integer> getMaxCapacity() {
        return maxCapacity;
    }
    
    
    public void mejorarCentroDeMando(){
        int temp = 0;
        this.nivel += 1;
        switch (this.nivel) {
            case 1:
                for (Map.Entry<Type, Integer> recurso : this.maxCapacity.entrySet()) {
                    temp =(int)((double)recurso.getValue() *1.1);
                    recurso.setValue(temp);
                }   break;
            case 2:
                for (Map.Entry<Type, Integer> recurso : this.maxCapacity.entrySet()) {
                    temp =(int)((double)recurso.getValue() *1.3);
                    recurso.setValue(temp);
                }   break;
            case 3:
                for (Map.Entry<Type, Integer> recurso : this.maxCapacity.entrySet()) {
                    temp =(int)((double)recurso.getValue() *1.5);
                    recurso.setValue(temp);
                }   break;
            default:
                break;
        }
    }

    @Override
    public void destruir() {
        System.out.println("El Centro de Mando ha sido Destruido");
        System.err.println("Game Over");
    }

    
}
