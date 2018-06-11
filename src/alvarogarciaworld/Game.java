/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alvarogarciaworld;

import Controller.Aldea.AldeaManager;
import View.Menu;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class Game {
    
    public static void initializeGame(){
  
       //Obteniendo instancia del menu para mostrar opciones
        Menu m  = Menu.getInstance();
        
        //Creando los jugadores
        AldeaManager playerOne = AldeaManager.getInstace(1);
        AldeaManager playerTwo =AldeaManager.getInstace(2);
        
    }
    
}
