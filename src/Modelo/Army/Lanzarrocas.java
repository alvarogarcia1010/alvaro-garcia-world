
package Modelo.Army;

import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class Lanzarrocas extends ArmyManager implements ArmyManagementInterface {

    public Lanzarrocas() {
        super(Type.LANZARROCAS.getNombre(),
              Type.LANZARROCAS,
              Type.LANZARROCAS.getVida(),
              Type.LANZARROCAS.getAttackPower(),
              Type.LANZARROCAS.getWaitTime(),0,false);
        this.cost.put(Type.LANZARROCAS.getRecurso1(),Type.LANZARROCAS.getCostR1());
        this.cost.put(Type.LANZARROCAS.getRecurso2(),Type.LANZARROCAS.getCostR2());
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
