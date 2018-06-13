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
public class LegendaryMachine extends MachineManager implements MachineManagementInterface{

    public LegendaryMachine() {
        super(Type.LEGENDARYMACHINE.getNombre(),
              Type.LEGENDARYMACHINE,
              Type.LEGENDARYMACHINE.getVida(),
              Type.LEGENDARYMACHINE.getAttackPower(),
              Type.LEGENDARYMACHINE.getWaitTime(),0,false);
        this.cost.put(Type.LEGENDARYMACHINE.getRecurso1(),Type.LEGENDARYMACHINE.getCostR1());
        this.cost.put(Type.LEGENDARYMACHINE.getRecurso2(),Type.LEGENDARYMACHINE.getCostR2());
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
