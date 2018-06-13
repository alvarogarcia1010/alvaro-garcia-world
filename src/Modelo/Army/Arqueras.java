
package Modelo.Army;

import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class Arqueras extends ArmyManager implements ArmyManagementInterface {

    public Arqueras() {
        super(Type.ARQUERAS.getNombre(),
              Type.ARQUERAS,
              Type.ARQUERAS.getVida(),
              Type.ARQUERAS.getAttackPower(),
              Type.ARQUERAS.getWaitTime(),0,false);
        this.cost.put(Type.ARQUERAS.getRecurso1(),Type.ARQUERAS.getCostR1());
        this.cost.put(Type.ARQUERAS.getRecurso2(),Type.ARQUERAS.getCostR2());
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
