
package View;

import javax.swing.*;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */

public class Menu {
    private static Menu instance;

    private Menu() {}

    public static Menu getInstance() {
        if (instance == null) {
            synchronized (Menu.class) {
                if (instance == null) {
                    instance = new Menu();
                }
            }

        }
        return instance;
    }
    
    public String insertarNombre(){
        String nombre;
        
        String msj = "Ingrese nombre del jugador";
        
        nombre = JOptionPane.showInputDialog(msj,null);
        
        return nombre;
    }
    
    public int razaOption(){
        int option;
        
        String options = "1. Vengadores de Flecha \n" +
                         "2. Caballeros de la Oscuridad \n" +
                         "3. Los Guerreros Z \n" +
                         "Elija la raza que desea elegir:";
        try {
            option = Integer.parseInt(JOptionPane.showInputDialog(options, null));
        }catch(NumberFormatException e){
            option = 5;
        }
        
        return option;
    }

    public int generalOptions() {
        int option;
        
        String options = "1. Administrar Estructuras \n" +
                         "2. Administrar Tropas \n" +
                         "3. Administrar Recursos \n" +
                         "4. Finalizar Turno \n" +
                         "Elija la opcion que desee:";
        try {
            option = Integer.parseInt(JOptionPane.showInputDialog(options, null));
        }catch(NumberFormatException e){
            option = 5;
        }
        
        return option;
    }
    
    public int buildingOptions(){
        int option;
             
        String options = "1. Mejorar Centro de Mando \n" +
                         "2. Construir Estructuras \n" +
                         "3. Mostrar Estructuras \n" +
                         "4. Atras \n" +
                         "Elija la opcion que desee:";
        try {
            option = Integer.parseInt(JOptionPane.showInputDialog(options, null));
        }catch(NumberFormatException e){
            option = 5;
        }
        
        return option;
    }
    
    public int armyOptions(){
        int option;
       
        String options = "1. Entrenar Tropas \n" +
                         "2. Mostrar Tropas Entrenadas \n" +
                         "3. Atacar \n" +
                         "4. Defender \n" +
                         "5. Atras \n" +
                         "Elija la opcion que desee:";
        try {
            option = Integer.parseInt(JOptionPane.showInputDialog(options, null));
        }catch(NumberFormatException e){
            option = 5;
        }
        
        return option;
    }
    
    public int resourcesOptions(){
        int option;
        
        String options = "1. Recolectar Zafiro \n" +
                         "2. Almacenar Oro \n" +
                         "3. Almacenar Diamantes \n" +
                         "4. Atras \n" +
                         "Elija la opcion que desee:";
        try {
            option = Integer.parseInt(JOptionPane.showInputDialog(options, null));
        }catch(NumberFormatException e){
            option = 5;
        }

        return option;
    }       
    
}
