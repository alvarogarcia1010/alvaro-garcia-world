/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Factory;

import Modelo.Army.ArmyManager;
import Modelo.Buildings.*;
import Modelo.Machines.MachineManager;
import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class FactoryBuilding implements AbstractFactory{

    @Override
    public ArmyManager getArmy(Type type) {
        return null;
    }

    @Override
    public BuildingManager getBuilding(Type type) {
        switch(type){
            case CUARTEL:
                return new Cuartel();
            case EXTRACTORDEZAFIRO:
                return new ExtractorDeZafiro();
            case HUESERA:
                return new Huesera();
            case MINADEDIAMANTE:
                return new MinaDeDiamante();
            case MINADEORO:
                return new MinaDeOro();
            case TALLER:
                return new Taller();
        }
        return null;
    }

    @Override
    public MachineManager getMachine(Type type) {
        return null;
    }
    
}
