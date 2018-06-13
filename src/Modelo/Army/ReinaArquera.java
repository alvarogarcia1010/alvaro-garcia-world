
package Modelo.Army;

import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class ReinaArquera extends ArmyManager implements ArmyManagementInterface {

    public ReinaArquera() {
        super(Type.REINAARQUERA.getNombre(),
              Type.REINAARQUERA,
              Type.REINAARQUERA.getVida(),
              Type.REINAARQUERA.getAttackPower(),
              Type.REINAARQUERA.getWaitTime(),0,false);
        this.cost.put(Type.REINAARQUERA.getRecurso1(),Type.REINAARQUERA.getCostR1());
        this.cost.put(Type.REINAARQUERA.getRecurso2(),Type.REINAARQUERA.getCostR2());
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
