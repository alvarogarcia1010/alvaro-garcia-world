/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Army;

import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class ReyBarbaro extends ArmyManager implements ArmyManagementInterface {

    public ReyBarbaro() {
        super(Type.REYBARBARO.getNombre(),
              Type.REYBARBARO,
              Type.REYBARBARO.getVida(),
              Type.REYBARBARO.getAttackPower(),
              Type.REYBARBARO.getWaitTime(),0,false);
        this.cost.put(Type.REYBARBARO.getRecurso1(),Type.REYBARBARO.getCostR1());
        this.cost.put(Type.REYBARBARO.getRecurso2(),Type.REYBARBARO.getCostR2());
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
