/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alvarogarciaworld;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class AlvaroGarciaWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Nombre: " + Type.ARQUERAS.getNombre());
        System.out.println("Tipo: " + Type.ARQUERAS.getTipo());
        System.out.println("Tiempo de espera: " + Type.ARQUERAS.getWaitTime());
        System.out.println("Vida: " + Type.ARQUERAS.getVida());
        System.out.println("Tipo de Recurso: " + Type.ARQUERAS.getRecurso1());
        System.out.println("Cantidad: " + Type.ARQUERAS.getCostR1());
        System.out.println("Tipo de Recurso: " + Type.ARQUERAS.getRecurso2());
        System.out.println("Cantidad: " + Type.ARQUERAS.getCostR2());
        System.out.println("Puntos de Ataque: " + Type.ARQUERAS.getAttackPower());
        
    }
    
}
