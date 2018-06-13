
package Modelo.Buildings;

import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class MinaDeOro extends BuildingManager implements BuildingManagementInterface{

    private int produccionxfase;
    private Type recurso;

    public MinaDeOro() {
        super(Type.MINADEORO.getNombre(),
        Type.MINADEORO,
        Type.MINADEORO.getVida(),
        Type.MINADEORO.getWaitTime(),0,false);
        this.addCost(Type.MINADEORO.getRecurso1(),Type.MINADEORO.getCostR1());
        this.addCost(Type.MINADEORO.getRecurso2(),Type.MINADEORO.getCostR2());
        this.recurso = Type.ORO;
        this.produccionxfase = 300;
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
        System.out.println("La Mina de Oro ha sido destruida");
    }
    
}
