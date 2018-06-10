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
public class LosGuerrerosZ extends RazaManager {
    
    public LosGuerrerosZ() {
        super(Type.RAZA3.getName(), false, "Tropas con mayor vida");
        this.tropasDisponibles.add(Type.REYBARBARO);
        this.tropasDisponibles.add(Type.BARBAROS);
        this.tropasDisponibles.add(Type.LANZARROCAS);
        
        this.vehiculosDisponibles.add(Type.WARMACHINE);
        this.vehiculosDisponibles.add(Type.GHOSTCAR);
    }
    
}
