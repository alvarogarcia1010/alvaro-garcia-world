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
public enum Type {
    ESPECIALISTA("Especialista",0,0), ESCUADRON("Escuadron",0,0), 
    RAZA1("Vengadores de Flecha",0,0), RAZA2("Caballeros de la Sombra",0,0), RAZA3("Los Guerreros Z",0,0),
    ORO("Oro",0,0),ZAFIRO("Zafiro",0,0), DIAMANTES("Diamantes",0,0),
    ARMY("Tropas",0,0), BUILDING("Edificios",0,0), MACHINE("Vehiculos",0,0),
    ARQUERAS("Arqueras"), BARBAROS("Barbaros"), BOMBARDEROS("Bombarderos"), GRANCENTINELA("Gran Centinela"), LANZARROCAS("Lanzarrocas"), MONTAPUERCOS("Montapuercos"), REINAARQUERA("Reina Arquera"), REYBARBARO("Rey Barbaro"), VALQUIRIAS("Valquirias"),
    CENTRODEMANDO("Centro de Mando"), CUARTEL("Cuartel"), EXTRACTORDEZAFIRO("Extractor de Zafiro"), HUESERA("Huesera"),MINADEDIAMANTE("Mina de Diamante"), MINADEORO("Mina de Oro"),TALLER("Taller"),
    BLACKWINDOW("Black Window"), DEATHCAR("Vehiculo de la muerte"), GHOSTCAR("Vehiculo Fantasma"), LEGENDARYMACHINE("Vehiculo Legendario"),STARKMACHINE("Vehiculo Stark"),WARMACHINE("Maquina de Guerra");
    
    private String nombre;
    private int vida;
    private int costo;
    
    private Type(String nombre, int vida, int costo){
        this.nombre = nombre;
        this.vida = vida;
        this.costo= costo;
    }
    
    public String getName(){
        return this.nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getCosto() {
        return costo;
    }
    
    

}
