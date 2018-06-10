
package Modelo.Buildings;

import Modelo.Machines.MachineManager;
import java.util.ArrayList;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class Taller extends BuildingManager implements BuildingManagementInterface{

    private String machineType;
    private ArrayList<MachineManager> machines;

    //CONSTRUCTOR
    
    //METODOS GETTER AND SETTER

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    
    
    //FUNCIONES 
    /**
     * This funtion add a MachineManager Object in the ArrayList
     * @param vehiculo
     */
    public void crearVehiculo(MachineManager vehiculo) {
        if((this.machines.size() <= 10) && (vehiculo.getNombre() == this.machineType)){
            this.machines.add(vehiculo);
            System.out.println("EL vehiculo " + vehiculo.getNombre() + " esta en creación");
            System.out.println("Tiempo de creacion estimado: " + vehiculo.getWaitTime() + " fases");

        }else{
            System.err.println("No se pueden crear mas vehiculos, la huesera esta en su capacidad maxima");
        }
    }

    /**
     * Delete a MachineManager object in the ArrayList
     * @param vehiculo 
     */
    public void removerTropa(MachineManager vehiculo) {
        if (this.machines.contains(vehiculo)) {
            this.machines.remove(vehiculo);
            System.out.println("EL vehiculo " + vehiculo.getNombre() + " ha sido eliminada");
        }
    }

    @Override
    public void destruir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
