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
public class AvengersOfArrow extends RazaManager {
    
    public AvengersOfArrow() {
        super(Type.RAZA1.getName(), false, "Tropas a bajo costo");
        this.tropasDisponibles.add(Type.ARQUERAS);
        this.tropasDisponibles.add(Type.VALQUIRIAS);
        this.tropasDisponibles.add(Type.REINAARQUERA);
        
        this.vehiculosDisponibles.add(Type.STARKMACHINE);
        this.vehiculosDisponibles.add(Type.BLACKWINDOW);
    }
    
}
