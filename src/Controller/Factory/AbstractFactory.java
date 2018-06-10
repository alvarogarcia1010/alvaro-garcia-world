/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Factory;

import Modelo.Army.ArmyManager;
import Modelo.Buildings.BuildingManager;
import Modelo.Machines.MachineManager;
import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public interface AbstractFactory {
    
    ArmyManager getArmy(Type type);
    BuildingManager getBuilding(Type type);
    MachineManager getMachine(Type type);
}
