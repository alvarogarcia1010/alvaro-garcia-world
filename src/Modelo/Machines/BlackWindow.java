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
public class BlackWindow extends MachineManager implements MachineManagementInterface{

    public BlackWindow() {
        super(Type.BLACKWINDOW.getNombre(),
        Type.BLACKWINDOW,
        Type.BLACKWINDOW.getVida(),
        Type.BLACKWINDOW.getAttackPower(),
        Type.BLACKWINDOW.getWaitTime(),0,false);
        this.cost.put(Type.BLACKWINDOW.getRecurso1(),Type.BLACKWINDOW.getCostR1());
        this.cost.put(Type.BLACKWINDOW.getRecurso2(),Type.BLACKWINDOW.getCostR2());
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
