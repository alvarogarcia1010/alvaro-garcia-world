
package Modelo.Buildings;

import Modelo.Machines.MachineManager;
import alvarogarciaworld.Type;
import java.util.ArrayList;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class Huesera extends BuildingManager implements BuildingManagementInterface{

    private String machineType;
    private ArrayList<MachineManager> machines;

    public Huesera() {
        super(Type.HUESERA.getNombre(),
        Type.HUESERA,
        Type.HUESERA.getVida(),
        Type.HUESERA.getWaitTime(),0,false);
        this.addCost(Type.HUESERA.getRecurso1(),Type.HUESERA.getCostR1());
        this.addCost(Type.HUESERA.getRecurso2(),Type.HUESERA.getCostR2());
        this.machines = new ArrayList<>();
    }

    //CONSTRUCTOR
    
    //METODOS GETTER AND SETTER
    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public ArrayList<MachineManager> getMachines() {
        return machines;
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
        System.out.println("La Huesera ha sido destruida");
    }
    
}
