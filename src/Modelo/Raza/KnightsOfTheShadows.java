/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Raza;

import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class KnightsOfTheShadows extends RazaManager {

    public KnightsOfTheShadows() {
        super(Type.RAZA2.getName(), false, "Tropas mas fuertes");
        this.tropasDisponibles.add(Type.GRANCENTINELA);
        this.tropasDisponibles.add(Type.MONTAPUERCOS);
        this.tropasDisponibles.add(Type.BOMBARDEROS);
        
        this.vehiculosDisponibles.add(Type.DEATHCAR);
        this.vehiculosDisponibles.add(Type.LEGENDARYMACHINE);
    }


    
}
