
package Modelo.Buildings;

import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class ExtractorDeZafiro extends BuildingManager implements BuildingManagementInterface{

    private int produccionxfase;
    private Type recurso;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
