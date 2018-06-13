
package Modelo.Machines;

import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class WarMachine extends MachineManager implements MachineManagementInterface {

    public WarMachine() {
        super(Type.WARMACHINE.getNombre(),
              Type.WARMACHINE,
              Type.WARMACHINE.getVida(),
              Type.WARMACHINE.getAttackPower(),
              Type.WARMACHINE.getWaitTime(),0,false);
        this.cost.put(Type.WARMACHINE.getRecurso1(),Type.WARMACHINE.getCostR1());
        this.cost.put(Type.WARMACHINE.getRecurso2(),Type.WARMACHINE.getCostR2());
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
