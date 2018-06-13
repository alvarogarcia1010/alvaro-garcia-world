
package Modelo.Army;

import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class Barbaros extends ArmyManager implements ArmyManagementInterface {

    public Barbaros() {
        super(Type.BARBAROS.getNombre(),
              Type.BARBAROS,
              Type.BARBAROS.getVida(),
              Type.BARBAROS.getAttackPower(),
              Type.BARBAROS.getWaitTime(),0,false);
        this.cost.put(Type.BARBAROS.getRecurso1(),Type.BARBAROS.getCostR1());
        this.cost.put(Type.BARBAROS.getRecurso2(),Type.BARBAROS.getCostR2());
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
