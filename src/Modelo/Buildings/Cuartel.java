
package Modelo.Buildings;

import Modelo.Army.ArmyManager;
import alvarogarciaworld.Type;
import java.util.ArrayList;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class Cuartel extends BuildingManager implements BuildingManagementInterface{

    private ArrayList<ArmyManager> army;

    //CONSTRUCTOR
    public Cuartel() {
        super(Type.CUARTEL.getNombre(),
        Type.CUARTEL,
        Type.CUARTEL.getVida(),
        Type.CUARTEL.getWaitTime(),0,false);
        this.addCost(Type.CUARTEL.getRecurso1(),Type.CUARTEL.getCostR1());
        this.addCost(Type.CUARTEL.getRecurso2(),Type.CUARTEL.getCostR2());
        this.army = new ArrayList<>();
    }

    //METODOS GETTER AND SETTER
   
    public ArrayList<ArmyManager> getArmy() {    
        return army;
    }

    public void setArmy(ArrayList<ArmyManager> army) {
        this.army = army;
    }

    //FUNCIONES
    /**
     * This funtion add a ArmyManager Object in the ArrayList
     * @param tropa 
     */
    public void entrenarTropa(ArmyManager tropa) {
        if(this.army.size() <= 10){
            this.army.add(tropa);
            System.out.println("La tropa " + tropa.getNombre() + " esta en creación");
            System.out.println("Tiempo de creacion estimado: " + tropa.getWaitTime() + " fases");

        }else{
            System.err.println("El cuartel esta en su capacidad maxima");
        }
    }


    public void removerTropa(ArmyManager tropa) {
        if (this.army.contains(tropa)) {
            this.army.remove(tropa);
            System.out.println("La tropa " + tropa.getNombre() + " ha sido eliminada");
        }
    }

    @Override
    public void destruir() {
        System.out.println("El Cuartel ha sido Destruido");
    }
    
}
