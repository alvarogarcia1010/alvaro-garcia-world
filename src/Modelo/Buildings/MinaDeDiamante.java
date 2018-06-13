
package Modelo.Buildings;

import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class MinaDeDiamante extends BuildingManager implements BuildingManagementInterface{

    private int produccionxfase;
    private Type recurso;

    public MinaDeDiamante() {
        super(Type.MINADEDIAMANTE.getNombre(),
        Type.MINADEDIAMANTE,
        Type.MINADEDIAMANTE.getVida(),
        Type.MINADEDIAMANTE.getWaitTime(),0,false);
        this.addCost(Type.MINADEDIAMANTE.getRecurso1(),Type.MINADEDIAMANTE.getCostR1());
        this.addCost(Type.MINADEDIAMANTE.getRecurso2(),Type.MINADEDIAMANTE.getCostR2());
        this.recurso = Type.DIAMANTES;
        this.produccionxfase = 500;
    }

    //CONSTRUCTOR
    
    //METODOS GETTER AND SETTER
    public int getProduccionxfase() {
        return produccionxfase;
    }

    public void setProduccionxfase(int produccionxfase) {
        this.produccionxfase = produccionxfase;
    }

    public Type getRecurso() {
        return recurso;
    }

    public void setRecurso(Type recurso) {
        this.recurso = recurso;
    }
    
    
    //FUNCIONES 
    public void recolectarRecurso(){
        
    }
    

    @Override
    public void destruir() {
        System.out.println("La mina de diamantes ha sido destruida");
    }
    
}
