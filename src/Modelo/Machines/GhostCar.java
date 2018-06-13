/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Machines;

import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class GhostCar extends MachineManager implements MachineManagementInterface{

    public GhostCar() {
        super(Type.GHOSTCAR.getNombre(),
              Type.GHOSTCAR,
              Type.GHOSTCAR.getVida(),
              Type.GHOSTCAR.getAttackPower(),
              Type.GHOSTCAR.getWaitTime(),0,false);
        this.cost.put(Type.GHOSTCAR.getRecurso1(),Type.GHOSTCAR.getCostR1());
        this.cost.put(Type.GHOSTCAR.getRecurso2(),Type.GHOSTCAR.getCostR2());
    }

    @Override
    public void atacar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void defender() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void morir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
