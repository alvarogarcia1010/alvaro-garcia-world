
package Modelo.Army;

import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class Valquirias extends ArmyManager implements ArmyManagementInterface {

    public Valquirias() {
        super(Type.VALQUIRIAS.getNombre(),
              Type.VALQUIRIAS,
              Type.VALQUIRIAS.getVida(),
              Type.VALQUIRIAS.getAttackPower(),
              Type.VALQUIRIAS.getWaitTime(),0,false);
        this.cost.put(Type.VALQUIRIAS.getRecurso1(),Type.VALQUIRIAS.getCostR1());
        this.cost.put(Type.VALQUIRIAS.getRecurso2(),Type.VALQUIRIAS.getCostR2());
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
