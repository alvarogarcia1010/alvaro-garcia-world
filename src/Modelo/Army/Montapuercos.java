
package Modelo.Army;

import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class Montapuercos extends ArmyManager implements ArmyManagementInterface {

    public Montapuercos() {
        super(Type.MONTAPUERCOS.getNombre(),
              Type.MONTAPUERCOS,
              Type.MONTAPUERCOS.getVida(),
              Type.MONTAPUERCOS.getAttackPower(),
              Type.MONTAPUERCOS.getWaitTime(),0,false);
        this.cost.put(Type.MONTAPUERCOS.getRecurso1(),Type.MONTAPUERCOS.getCostR1());
        this.cost.put(Type.MONTAPUERCOS.getRecurso2(),Type.MONTAPUERCOS.getCostR2());
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
