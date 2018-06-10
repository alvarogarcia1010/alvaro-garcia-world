
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
    
    //METODOS GETTER AND SETTER

    
    
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
