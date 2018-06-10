/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Factory;

import Modelo.Army.ArmyManager;
import Modelo.Buildings.BuildingManager;
import Modelo.Machines.*;
import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class FactoryMachine implements AbstractFactory{

    @Override
    public ArmyManager getArmy(Type type) {
        return null;
    }

    @Override
    public BuildingManager getBuilding(Type type) {
        return null;
    }

    @Override
    public MachineManager getMachine(Type type) {
      switch(type){
          case BLACKWINDOW:
              return new BlackWindow();
          case DEATHCAR:
              return new DeathCar();
          case GHOSTCAR:
              return new GhostCar();
          case LEGENDARYMACHINE:
              return new LegendaryMachine();
          case STARKMACHINE:
              return new StarkMachine();
          case WARMACHINE:
              return new WarMachine();
      }
      return null;
    }
    
}
