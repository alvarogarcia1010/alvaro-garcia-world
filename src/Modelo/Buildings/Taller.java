
package Modelo.Buildings;

import Modelo.Machines.MachineManager;
import alvarogarciaworld.Type;
import java.util.ArrayList;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class Taller extends BuildingManager implements BuildingManagementInterface{

    private String machineType;
    private ArrayList<MachineManager> machines;

    public Taller() {
        super(Type.TALLER.getNombre(),
        Type.TALLER,
        Type.TALLER.getVida(),
        Type.TALLER.getWaitTime(),0,false);
        this.addCost(Type.TALLER.getRecurso1(),Type.TALLER.getCostR1());
        this.addCost(Type.TALLER.getRecurso2(),Type.TALLER.getCostR2());
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
