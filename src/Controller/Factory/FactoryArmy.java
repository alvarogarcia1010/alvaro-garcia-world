/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Factory;

import Modelo.Army.*;
import Modelo.Buildings.BuildingManager;
import Modelo.Machines.MachineManager;
import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class FactoryArmy implements AbstractFactory{

    @Override
    public ArmyManager getArmy(Type type) {
        switch(type){
            case ARQUERAS:
                return new Arqueras();
            case BARBAROS:
                return new Barbaros();
            case BOMBARDEROS:
                return new Bombarderos();
            case GRANCENTINELA:
                return new GranCentinela();
            case LANZARROCAS:
                return new Lanzarrocas();
            case MONTAPUERCOS:
                return new Montapuercos();
            case REINAARQUERA:
                return new ReinaArquera();
            case REYBARBARO:
                return new ReyBarbaro();
            case VALQUIRIAS:
                return new Valquirias();
        }
        return null;
    }

    @Override
    public BuildingManager getBuilding(Type type) {
        return null;
    }

    @Override
    public MachineManager getMachine(Type type) {
        return null;
    }
    
}
