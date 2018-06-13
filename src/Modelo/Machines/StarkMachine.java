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
public class StarkMachine extends MachineManager implements MachineManagementInterface{

    public StarkMachine() {
        super(Type.STARKMACHINE.getNombre(),
              Type.STARKMACHINE,
              Type.STARKMACHINE.getVida(),
              Type.STARKMACHINE.getAttackPower(),
              Type.STARKMACHINE.getWaitTime(),0,false);
        this.cost.put(Type.STARKMACHINE.getRecurso1(),Type.STARKMACHINE.getCostR1());
        this.cost.put(Type.STARKMACHINE.getRecurso2(),Type.STARKMACHINE.getCostR2());
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
