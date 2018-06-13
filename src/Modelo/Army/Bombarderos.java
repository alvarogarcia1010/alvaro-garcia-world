
package Modelo.Army;

import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class Bombarderos extends ArmyManager implements ArmyManagementInterface {

    public Bombarderos() {
        super(Type.BOMBARDEROS.getNombre(),
              Type.BOMBARDEROS,
              Type.BOMBARDEROS.getVida(),
              Type.BOMBARDEROS.getAttackPower(),
              Type.BOMBARDEROS.getWaitTime(),0,false);
        this.cost.put(Type.BOMBARDEROS.getRecurso1(),Type.BOMBARDEROS.getCostR1());
        this.cost.put(Type.BOMBARDEROS.getRecurso2(),Type.BOMBARDEROS.getCostR2());
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
