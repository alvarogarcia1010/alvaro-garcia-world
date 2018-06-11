
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
                         "5. Atras \n" +
                         "Elija la opcion que desee:";
        try {
            option = Integer.parseInt(JOptionPane.showInputDialog(options, null));
        }catch(NumberFormatException e){
            option = 5;
        }

        return option;
    }    
    
    
    

    public void showMain() {
        int option;

        while (true) {
            generalOptions();
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion ", null));
            } catch (NumberFormatException e) {
                option = 5;
            }

            switch (option) {
                case 1:
                    System.out.println("Abriendo Administrado Pa");
                    break;
                case 2:
                    System.out.println("Abriendo Administrado Me");
                    break;
                case 3:
                    System.out.println("Abriendo Administrado His");
                    break;
                case 4:
                    return;
                default:
                    System.err.println("Por favor ingrese una opcion valida ");
            }
        }
    }

    
    
}
