
package Modelo.Army;

import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class GranCentinela extends ArmyManager implements ArmyManagementInterface {

    public GranCentinela() {
        super(Type.GRANCENTINELA.getNombre(),
              Type.GRANCENTINELA,
              Type.GRANCENTINELA.getVida(),
              Type.GRANCENTINELA.getAttackPower(),
              Type.GRANCENTINELA.getWaitTime(),0,false);
        this.cost.put(Type.GRANCENTINELA.getRecurso1(),Type.GRANCENTINELA.getCostR1());
        this.cost.put(Type.GRANCENTINELA.getRecurso2(),Type.GRANCENTINELA.getCostR2());
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
