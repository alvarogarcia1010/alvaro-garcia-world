
package Modelo.Buildings;

import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class ExtractorDeZafiro extends BuildingManager implements BuildingManagementInterface{

    private int produccionxfase;
    private Type recurso;

    public ExtractorDeZafiro() {
        super(Type.EXTRACTORDEZAFIRO.getNombre(),
              Type.EXTRACTORDEZAFIRO,
              Type.EXTRACTORDEZAFIRO.getVida(),
              Type.EXTRACTORDEZAFIRO.getWaitTime(),0,false);
        this.addCost(Type.EXTRACTORDEZAFIRO.getRecurso1(),Type.EXTRACTORDEZAFIRO.getCostR1());
        this.addCost(Type.EXTRACTORDEZAFIRO.getRecurso2(),Type.EXTRACTORDEZAFIRO.getCostR2());
        this.recurso = Type.ZAFIRO;
        this.produccionxfase = 1500;
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
        System.out.println("El recolector de zafiro ha sido destruido");
    }

}
