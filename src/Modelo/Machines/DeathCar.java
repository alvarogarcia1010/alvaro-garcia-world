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
public class DeathCar extends MachineManager implements MachineManagementInterface{

    public DeathCar() {
        super(Type.DEATHCAR.getNombre(),
              Type.DEATHCAR,
              Type.DEATHCAR.getVida(),
              Type.DEATHCAR.getAttackPower(),
              Type.DEATHCAR.getWaitTime(),0,false);
        this.cost.put(Type.DEATHCAR.getRecurso1(),Type.DEATHCAR.getCostR1());
        this.cost.put(Type.DEATHCAR.getRecurso2(),Type.DEATHCAR.getCostR2());
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
