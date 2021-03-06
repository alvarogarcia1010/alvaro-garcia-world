/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alvarogarciaworld;

import Controller.Aldea.AldeaManager;
import Modelo.Raza.*;
import View.Menu;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class Game {

    public static void initializeGame(){

       try{
        //Obteniendo instancia del menu para mostrar opciones
        Menu m  = Menu.getInstance();
        int option;
        boolean aldeaDestruida = false;

        RazaManager raza1 = RazaProducer.getFactory(Type.AVENGERSOFARROW);
        RazaManager raza2 = RazaProducer.getFactory(Type.KNIGHTSOFTHESHADOWS);
        RazaManager raza3 = RazaProducer.getFactory(Type.LOSGUERREROSZ);

        //Creando los jugadores con su centro de mando y recursos
        AldeaManager playerOne = AldeaManager.getInstance(1);
        AldeaManager playerTwo =AldeaManager.getInstance(2);

        //Para Jugador 1
        System.out.println("Jugador Uno \n");
        playerOne.setNombreJugador(m.insertarNombre());

        System.out.println("Razas disponibles:");

        System.out.println("<============== " + "Raza: " + Type.AVENGERSOFARROW.getNombre() + " ==============>");
        raza1.showArmyAvailable();
        raza1.showBuildingAvailable();
        raza1.showMachinesAvailable();
        System.out.print("\n");

        Thread.sleep(1000);

        System.out.println("<============== " + "Raza: " + Type.KNIGHTSOFTHESHADOWS.getNombre() + " ==============>");
        raza2.showArmyAvailable();
        raza2.showBuildingAvailable();
        raza2.showMachinesAvailable();
        System.out.print("\n");

        Thread.sleep(1000);
        System.out.println("<============== " + "Raza: " + Type.LOSGUERREROSZ.getNombre() + " ==============>");
        raza3.showArmyAvailable();
        raza3.showBuildingAvailable();
        raza3.showMachinesAvailable();
        System.out.print("\n");

        option = m.razaOption();
        while(option>3){
            option = m.razaOption();
        }

        switch(option){
            case 1:
                playerOne.setRazaDisponible(raza1);
                break;
            case 2:
                playerOne.setRazaDisponible(raza2);
                break;
            case 3:
                playerOne.setRazaDisponible(raza3);
                break;
            default:
                playerOne.setRazaDisponible(raza1);
                break;
        }

        //Para Jugador 2

        System.out.println("Jugador Dos \n");
        playerTwo.setNombreJugador(m.insertarNombre());

        System.out.println("Razas disponibles:");

        System.out.println("<============== " + "Raza: " + Type.AVENGERSOFARROW.getNombre() + " ==============>");
        raza1.showArmyAvailable();
        raza1.showBuildingAvailable();
        raza1.showMachinesAvailable();
        System.out.print("\n");

        Thread.sleep(1000);

        System.out.println("<============== " + "Raza: " + Type.KNIGHTSOFTHESHADOWS.getNombre() + " ==============>");
        raza2.showArmyAvailable();
        raza2.showBuildingAvailable();
        raza2.showMachinesAvailable();
        System.out.print("\n");

        Thread.sleep(1000);
        System.out.println("<============== " + "Raza: " + Type.LOSGUERREROSZ.getNombre() + " ==============>");
        raza3.showArmyAvailable();
        raza3.showBuildingAvailable();
        raza3.showMachinesAvailable();
        System.out.print("\n");
        Thread.sleep(1000);
        option = m.razaOption();
        while(option>3){
            option = m.razaOption();
        }

        switch(option){
            case 1:
                playerTwo.setRazaDisponible(raza1);
                break;
            case 2:
                playerTwo.setRazaDisponible(raza2);
                break;
            case 3:
                playerTwo.setRazaDisponible(raza3);
                break;
            default:
                playerTwo.setRazaDisponible(raza1);
                break;
        }


        System.out.println(playerOne.getNombreJugador());
        System.out.println(playerTwo.getNombreJugador());

        //Logica del juego
        while(!aldeaDestruida){
            if(playerOne.getEdificiosConstruidos().isEmpty() || playerTwo.getEdificiosConstruidos().isEmpty()){
                if(playerOne.getEdificiosConstruidos().isEmpty()){
                    System.out.println(playerTwo.getNombreJugador() + " es el ganador");
                }
                else{
                    System.out.println(playerOne.getNombreJugador() + " es el ganador");
                }
                aldeaDestruida = true;
                break;
            }

            playerOne.verificarUso();
            playerOne.turno(playerTwo);

            playerTwo.verificarUso();
            playerTwo.turno(playerOne);
            
            if(playerOne.isIsAttack()){
                if(playerOne.getFaseComienzoAtaque()+2 >=playerOne.getFaseActual()){
                    playerOne.realizarAtaque(playerTwo);
                }else{
                    System.out.println("Las tropas del jugador"+ playerOne.getNombreJugador() + "van en camino");
                }
            }
            
            if(playerTwo.isIsAttack()){
                if(playerTwo.getFaseComienzoAtaque()+2 >=playerTwo.getFaseActual()){
                    playerTwo.realizarAtaque(playerOne);
                }else{
                    System.out.println("Las tropas del jugador"+ playerTwo.getNombreJugador() + "van en camino");
                }
            }
            
            if(playerOne.isIsDefend()){
                playerOne.realizarDefensa(playerTwo);
            }
            
            if(playerTwo.isIsDefend()){
                playerTwo.realizarDefensa(playerOne);
            }

            playerOne.avanzarFase();
            playerTwo.avanzarFase();
        }



        }catch(InterruptedException e){
           System.err.println("Lo sentimos, hubo un error de compilacion :(");
        }

    }

}
