/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Aldea;

import Controller.Factory.AbstractFactory;
import Controller.Factory.FactoryProducer;
import Modelo.Army.*;
import Modelo.Buildings.*;
import Modelo.Machines.*;
import Modelo.Raza.*;
import View.Menu;
import alvarogarciaworld.Type;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class AldeaManager implements AldeaManagementInterface{
    private String nombreJugador;
    private int faseActual;
    private RazaManager razaDisponible;
    private CentroDeMando centroDeMando;
    private TreeMap<Type, Integer> recursosDisponibles;
    private ArrayList<BuildingManager> edificiosConstruidos;
    private ArrayList<ArmyManager> tropasPreparadas;
    private ArrayList<MachineManager> vehiculosPreparados;
    private Menu m;

    private static AldeaManager[] instance = new AldeaManager[2];


    //Constructor
    private AldeaManager(int aldea){

        this.edificiosConstruidos = new ArrayList<>();
        this.tropasPreparadas = new ArrayList<>();
        this.vehiculosPreparados = new ArrayList<>();
        this.recursosDisponibles = new TreeMap<>();

        //Crear Centro de Mando
        this.centroDeMando = CentroDeMando.getInstance(aldea);
        this.edificiosConstruidos.add(0,this.centroDeMando);

        //Inicializo los valores de los recursos
        this.recursosDisponibles.put(Type.ORO, 4000);
        this.recursosDisponibles.put(Type.DIAMANTES, 2250);
        this.recursosDisponibles.put(Type.ZAFIRO, 9000);

        this.faseActual = 1;
        this.m = Menu.getInstance();
    };


    /**
     * Method getInstance (Singleton)
     * @param aldea
     * @return AldeaManager Instance
     */
    public synchronized static AldeaManager getInstance(int aldea){
        if(aldea == 1){
            if(instance[0] == null){
                instance[0] = new AldeaManager(aldea);
            }
            return instance[0];
        }else if (aldea == 2){
            if(instance[1] == null){
                instance[1] = new AldeaManager(aldea);
            }
            return instance[1];
        }else{
            return null;
        }


    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getFaseActual() {
        return faseActual;
    }

    public void setFaseActual(int faseActual) {
        this.faseActual = faseActual;
    }

    public RazaManager getRazaDisponible() {
        return razaDisponible;
    }

    public void setRazaDisponible(RazaManager razaDisponible) {
        this.razaDisponible = razaDisponible;
    }

    public TreeMap<Type, Integer> getRecursosDisponibles() {
        return recursosDisponibles;
    }

    public ArrayList<BuildingManager> getEdificiosConstruidos() {
        return edificiosConstruidos;
    }

    public ArrayList<ArmyManager> getTropasPreparadas() {
        return tropasPreparadas;
    }

    public ArrayList<MachineManager> getVehiculosPreparados() {
        return vehiculosPreparados;
    }

    public int validarEleccion(Type tipo){
        int opcion;
        String msj = "Se gastará los siguientes recursos \n"+
                     tipo.getRecurso1() + ": " + tipo.getCostR1() + "\n" +
                     tipo.getRecurso2() + ": " + tipo.getCostR2() + "\n" +
                     "Desea continuar:\n 1.Si \n 2.No";

        try {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(msj, null));
        }catch(NumberFormatException e){
            opcion = 2;
        }
        return opcion;

    }

    public boolean verificarRecursos(Type tipo){
        boolean prueba;

        prueba = (tipo.getCostR1() <= this.recursosDisponibles.get(tipo.getRecurso1())) &&
                 (tipo.getCostR2() <= this.recursosDisponibles.get(tipo.getRecurso2()));


        return prueba;
    }

    public ArrayList<BuildingManager> buscarEdificio(Type edificio) {
            ArrayList<BuildingManager> edificiosEncontrados = new ArrayList<>();
            for (BuildingManager edificacion : this.edificiosConstruidos) {
                if (edificacion.getTipo().equals(edificio)) {
                    edificiosEncontrados.add(edificacion);
                }
            }
        return edificiosEncontrados;
    }

    public int contarOcurrencias(Type edificio) {
        int cont = 0;
        for (BuildingManager edificacion : this.edificiosConstruidos) {
            if (edificacion.getTipo().equals(edificio)) {
                cont += 1;
            }
        }
        return cont;
    }

    public int elegirTropa(){
        String disponibles = "Tropas disponibles: \n";
        int opcion;

        for (int i = 0; i <= this.razaDisponible.getTropasDisponibles().size()-1; i++) {
            disponibles = disponibles + (i+1) + ". " + this.razaDisponible.getTropasDisponibles().get(i).getNombre() + "\n";
        }

        try {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(disponibles, null));
        }catch(NumberFormatException e){
            opcion = 10;
        }
        return opcion;
    }

    //Constructor debe inicializar los recursos y crear el centro de mando
    /**
     * Agrega una tropa a la lista de topas
     */
    @Override
    public void entrenarTropa(){
        ArrayList<BuildingManager> cuarteles = this.buscarEdificio(Type.CUARTEL);

        int opcion = this.elegirTropa();
        int subOpcion, newCant;
        AbstractFactory fabrica = FactoryProducer.getFactory(Type.ARMY);
        ArmyManager temp;
        String msj;
        boolean verificarRecursos, verificarConstruccion = true;

        if(!cuarteles.isEmpty()){
            for (BuildingManager edificio : cuarteles){
                verificarConstruccion = verificarConstruccion && edificio.isIsEnable();
            }
            if(verificarConstruccion){
                switch(opcion){
                    case 1:
                           subOpcion = this.validarEleccion(this.razaDisponible.getTropasDisponibles().get(0));
                           switch(subOpcion){
                               case 1:
                                    verificarRecursos = this.verificarRecursos(this.razaDisponible.getTropasDisponibles().get(0));
                                    if(verificarRecursos){
                                         temp = fabrica.getArmy(this.razaDisponible.getTropasDisponibles().get(0));
                                         temp.setCreationFase(this.faseActual);

                                         newCant = this.recursosDisponibles.get(this.razaDisponible.getTropasDisponibles().get(0).getRecurso1()) - this.razaDisponible.getTropasDisponibles().get(0).getCostR1();
                                         this.recursosDisponibles.put(this.razaDisponible.getTropasDisponibles().get(0).getRecurso1(), newCant);
                                         newCant = this.recursosDisponibles.get(this.razaDisponible.getTropasDisponibles().get(0).getRecurso2()) - this.razaDisponible.getTropasDisponibles().get(0).getCostR2();
                                         this.recursosDisponibles.put(this.razaDisponible.getTropasDisponibles().get(0).getRecurso2(), newCant);

                                         msj = this.razaDisponible.getTropasDisponibles().get(0).getNombre() +" se estan entrenando \n Fases a esperar: " + temp.getWaitTime() +"\n";
                                         this.tropasPreparadas.add(temp);
                                         JOptionPane.showMessageDialog(null,msj);
                                    }else{
                                         msj = "Recursos Insuficientes para entrenar " +this.razaDisponible.getTropasDisponibles().get(0).getNombre();
                                         JOptionPane.showMessageDialog(null,msj);
                                    }
                                    break;
                               default:
                                   msj = "Entrenamiento cancelada";
                                   JOptionPane.showMessageDialog(null,msj);
                                   break;
                           }
                        break;
                    case 2:
                           subOpcion = this.validarEleccion(this.razaDisponible.getTropasDisponibles().get(1));
                           switch(subOpcion){
                               case 1:
                                    verificarRecursos = this.verificarRecursos(this.razaDisponible.getTropasDisponibles().get(1));
                                    if(verificarRecursos){
                                         temp = fabrica.getArmy(this.razaDisponible.getTropasDisponibles().get(1));
                                         temp.setCreationFase(this.faseActual);

                                         newCant = this.recursosDisponibles.get(this.razaDisponible.getTropasDisponibles().get(1).getRecurso1()) - this.razaDisponible.getTropasDisponibles().get(1).getCostR1();
                                         this.recursosDisponibles.put(this.razaDisponible.getTropasDisponibles().get(1).getRecurso1(), newCant);
                                         newCant = this.recursosDisponibles.get(this.razaDisponible.getTropasDisponibles().get(1).getRecurso2()) - this.razaDisponible.getTropasDisponibles().get(1).getCostR2();
                                         this.recursosDisponibles.put(this.razaDisponible.getTropasDisponibles().get(1).getRecurso2(), newCant);

                                         msj = this.razaDisponible.getTropasDisponibles().get(1).getNombre() + " se estan entrenando \n Fases a esperar: " + temp.getWaitTime() +"\n";
                                         this.tropasPreparadas.add(temp);
                                         JOptionPane.showMessageDialog(null,msj);
                                    }else{
                                         msj = "Recursos Insuficientes para entrenar " + this.razaDisponible.getTropasDisponibles().get(1).getNombre();
                                         JOptionPane.showMessageDialog(null,msj);
                                    }
                                    break;
                               default:
                                   msj = "Entrenamiento cancelada";
                                   JOptionPane.showMessageDialog(null,msj);
                                   break;
                           }
                        break;
                    case 3:
                           subOpcion = this.validarEleccion(this.razaDisponible.getTropasDisponibles().get(2));
                           switch(subOpcion){
                               case 1:
                                    verificarRecursos = this.verificarRecursos(this.razaDisponible.getTropasDisponibles().get(2));
                                    if(verificarRecursos){
                                         temp = fabrica.getArmy(this.razaDisponible.getTropasDisponibles().get(2));
                                         temp.setCreationFase(this.faseActual);

                                         newCant = this.recursosDisponibles.get(this.razaDisponible.getTropasDisponibles().get(2).getRecurso1()) - this.razaDisponible.getTropasDisponibles().get(2).getCostR1();
                                         this.recursosDisponibles.put(this.razaDisponible.getTropasDisponibles().get(2).getRecurso1(), newCant);
                                         newCant = this.recursosDisponibles.get(this.razaDisponible.getTropasDisponibles().get(2).getRecurso2()) - this.razaDisponible.getTropasDisponibles().get(2).getCostR2();
                                         this.recursosDisponibles.put(this.razaDisponible.getTropasDisponibles().get(2).getRecurso2(), newCant);

                                         msj = this.razaDisponible.getTropasDisponibles().get(2).getNombre() +" se estan entrenando \n Fases a esperar: " + temp.getWaitTime() +"\n";
                                         this.tropasPreparadas.add(temp);
                                         JOptionPane.showMessageDialog(null,msj);
                                    }else{
                                         msj = "Recursos Insuficientes para entrenar " + this.razaDisponible.getTropasDisponibles().get(2).getNombre();
                                         JOptionPane.showMessageDialog(null,msj);
                                    }
                                    break;
                               default:
                                   msj = "Entrenamiento cancelada";
                                   JOptionPane.showMessageDialog(null,msj);
                                   break;
                           }
                        break;
                    default:
                        break;
                }
            }else{
                msj = "¡No se puede entrenar tropa! \n Cuarteles en construccion";
                JOptionPane.showMessageDialog(null,msj);
            }
        }else{
            msj = "¡No se puede entrenar tropa! \n Primero construya un Cuartel";
            JOptionPane.showMessageDialog(null,msj);
        }
    }

    public int elegirEdificio(){
        String disponibles = "Edificios disponibles: \n";
        int opcion;

        for (int i = 1; i <= this.razaDisponible.getEdificacionesDisponibles().size()-1; i++) {
            disponibles = disponibles + i + ". " + this.razaDisponible.getEdificacionesDisponibles().get(i).getNombre() + "\n";
        }

        try {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(disponibles, null));
        }catch(NumberFormatException e){
            opcion = 10;
        }
        return opcion;
    }

    /**
     * Agrega un edificio a lista de edificios
     */
    @Override
    public void construirEdificio(){
            int opcion = this.elegirEdificio();
            int subOpcion, newCant;
            AbstractFactory fabrica = FactoryProducer.getFactory(Type.BUILDING);
            BuildingManager temp;
            String msj;
            boolean verificarRecursos;

            switch(opcion){
               case 1:
                   subOpcion = this.validarEleccion(Type.CUARTEL);
                   switch(subOpcion){
                       case 1:
                            verificarRecursos = this.verificarRecursos(Type.CUARTEL);
                            if(verificarRecursos){
                                 temp = fabrica.getBuilding(Type.CUARTEL);
                                 temp.setCreationFase(this.faseActual);

                                 newCant = this.recursosDisponibles.get(Type.CUARTEL.getRecurso1()) - Type.CUARTEL.getCostR1();
                                 this.recursosDisponibles.put(Type.CUARTEL.getRecurso1(), newCant);
                                 newCant = this.recursosDisponibles.get(Type.CUARTEL.getRecurso2()) - Type.CUARTEL.getCostR2();
                                 this.recursosDisponibles.put(Type.CUARTEL.getRecurso2(), newCant);

                                 msj = "Cuartel en construccion\n Fases a esperar: " + temp.getWaitTime() +"\n";
                                 this.edificiosConstruidos.add(temp);
                                 JOptionPane.showMessageDialog(null,msj);
                            }else{
                                 msj = "Recursos Insuficientes para construir el cuartel";
                                 JOptionPane.showMessageDialog(null,msj);
                            }
                        break;
                       default:
                           msj = "Construccion cancelada";
                           JOptionPane.showMessageDialog(null,msj);
                           break;
                   }
                   break;
                case 2:
                   subOpcion = this.validarEleccion(Type.EXTRACTORDEZAFIRO);
                   switch(subOpcion){
                       case 1:
                            verificarRecursos = this.verificarRecursos(Type.EXTRACTORDEZAFIRO);
                            if(verificarRecursos){
                                 temp = fabrica.getBuilding(Type.EXTRACTORDEZAFIRO);
                                 temp.setCreationFase(this.faseActual);

                                 newCant = this.recursosDisponibles.get(Type.EXTRACTORDEZAFIRO.getRecurso1()) - Type.EXTRACTORDEZAFIRO.getCostR1();
                                 this.recursosDisponibles.put(Type.EXTRACTORDEZAFIRO.getRecurso1(), newCant);
                                 newCant = this.recursosDisponibles.get(Type.EXTRACTORDEZAFIRO.getRecurso2()) - Type.EXTRACTORDEZAFIRO.getCostR2();
                                 this.recursosDisponibles.put(Type.EXTRACTORDEZAFIRO.getRecurso2(), newCant);

                                 msj = "Extractor de zafiro en construccion\n Fases a esperar: " + temp.getWaitTime() +"\n";
                                 this.edificiosConstruidos.add(temp);
                                 JOptionPane.showMessageDialog(null,msj);
                            }else{
                                 msj = "Recursos Insuficientes para construir el extractor de zafiro";
                                 JOptionPane.showMessageDialog(null,msj);
                            }
                        break;
                       default:
                           msj = "Construccion cancelada";
                           JOptionPane.showMessageDialog(null,msj);
                           break;
                   }
                   break;
                case 3:
                   subOpcion = this.validarEleccion(Type.HUESERA);
                   switch(subOpcion){
                       case 1:
                            verificarRecursos = this.verificarRecursos(Type.HUESERA);
                            if(verificarRecursos){
                                 temp = fabrica.getBuilding(Type.HUESERA);
                                 temp.setCreationFase(this.faseActual);

                                 newCant = this.recursosDisponibles.get(Type.HUESERA.getRecurso1()) - Type.HUESERA.getCostR1();
                                 this.recursosDisponibles.put(Type.HUESERA.getRecurso1(), newCant);
                                 newCant = this.recursosDisponibles.get(Type.HUESERA.getRecurso2()) - Type.HUESERA.getCostR2();
                                 this.recursosDisponibles.put(Type.HUESERA.getRecurso2(), newCant);

                                 msj = "Huesera en construccion\n Fases a esperar: " + temp.getWaitTime() +"\n";
                                 this.edificiosConstruidos.add(temp);
                                 JOptionPane.showMessageDialog(null,msj);
                            }else{
                                 msj = "Recursos Insuficientes para construir la huesera";
                                 JOptionPane.showMessageDialog(null,msj);
                            }
                          break;
                       default:
                           msj = "Construccion cancelada";
                           JOptionPane.showMessageDialog(null,msj);
                           break;
                   }
                   break;
                case 4:
                   subOpcion = this.validarEleccion(Type.MINADEDIAMANTE);
                   switch(subOpcion){
                       case 1:
                            verificarRecursos = this.verificarRecursos(Type.MINADEDIAMANTE);
                            if(verificarRecursos){
                                 temp = fabrica.getBuilding(Type.MINADEDIAMANTE);
                                 temp.setCreationFase(this.faseActual);

                                 newCant = this.recursosDisponibles.get(Type.MINADEDIAMANTE.getRecurso1()) - Type.MINADEDIAMANTE.getCostR1();
                                 this.recursosDisponibles.put(Type.MINADEDIAMANTE.getRecurso1(), newCant);
                                 newCant = this.recursosDisponibles.get(Type.MINADEDIAMANTE.getRecurso2()) - Type.MINADEDIAMANTE.getCostR2();
                                 this.recursosDisponibles.put(Type.MINADEDIAMANTE.getRecurso2(), newCant);

                                 msj = "Mina de diamante en construccion\n Fases a esperar: " + temp.getWaitTime() +"\n";
                                 this.edificiosConstruidos.add(temp);
                                 JOptionPane.showMessageDialog(null,msj);
                            }else{
                                 msj = "Recursos Insuficientes para construir la mina de diamante";
                                 JOptionPane.showMessageDialog(null,msj);
                            }
                          break;
                       default:
                           msj = "Construccion cancelada";
                           JOptionPane.showMessageDialog(null,msj);
                           break;
                   }
                   break;
                case 5:
                   subOpcion = this.validarEleccion(Type.MINADEORO);
                   switch(subOpcion){
                       case 1:
                            verificarRecursos = this.verificarRecursos(Type.MINADEORO);
                            if(verificarRecursos){
                                 temp = fabrica.getBuilding(Type.MINADEORO);
                                 temp.setCreationFase(this.faseActual);

                                 newCant = this.recursosDisponibles.get(Type.MINADEORO.getRecurso1()) - Type.MINADEORO.getCostR1();
                                 this.recursosDisponibles.put(Type.MINADEORO.getRecurso1(), newCant);
                                 newCant = this.recursosDisponibles.get(Type.MINADEORO.getRecurso2()) - Type.MINADEORO.getCostR2();
                                 this.recursosDisponibles.put(Type.MINADEORO.getRecurso2(), newCant);

                                 msj = "Mina de Oro en construccion\n Fases a esperar: " + temp.getWaitTime() +"\n";
                                 this.edificiosConstruidos.add(temp);
                                 JOptionPane.showMessageDialog(null,msj);
                            }else{
                                 msj = "Recursos Insuficientes para construir la mina de oro";
                                 JOptionPane.showMessageDialog(null,msj);
                            }
                          break;
                       default:
                           msj = "Construccion cancelada";
                           JOptionPane.showMessageDialog(null,msj);
                           break;
                   }
                   break;
                case 6:
                   subOpcion = this.validarEleccion(Type.TALLER);
                   switch(subOpcion){
                       case 1:
                            verificarRecursos = this.verificarRecursos(Type.TALLER);
                            if(verificarRecursos){
                                 temp = fabrica.getBuilding(Type.TALLER);
                                 temp.setCreationFase(this.faseActual);

                                 newCant = this.recursosDisponibles.get(Type.TALLER.getRecurso1()) - Type.TALLER.getCostR1();
                                 this.recursosDisponibles.put(Type.TALLER.getRecurso1(), newCant);
                                 newCant = this.recursosDisponibles.get(Type.TALLER.getRecurso2()) - Type.TALLER.getCostR2();
                                 this.recursosDisponibles.put(Type.TALLER.getRecurso2(), newCant);

                                 msj = "Taller en construccion\n Fases a esperar: " + temp.getWaitTime() +"\n";
                                 this.edificiosConstruidos.add(temp);
                                 JOptionPane.showMessageDialog(null,msj);
                            }else{
                                 msj = "Recursos Insuficientes para construir el taller";
                                 JOptionPane.showMessageDialog(null,msj);
                            }
                            break;
                       default:
                           msj = "Construccion cancelada";
                           JOptionPane.showMessageDialog(null,msj);
                           break;
                   }
                   break;
                default:
                   break;
           }
    }

    public int elegirVehiculo(){
        String disponibles = "Vehiculos disponibles: \n";
        int opcion;

        for (int i = 0; i <= this.razaDisponible.getVehiculosDisponibles().size()-1; i++) {
            disponibles = disponibles + (i+1) + ". " + this.razaDisponible.getVehiculosDisponibles().get(i).getNombre() + "\n";
        }

        try {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(disponibles, null));
        }catch(NumberFormatException e){
            opcion = 10;
        }
        return opcion;
    }

    /**
     * Agrega un vehiculo a lista de edificios
     */
    @Override
    public void crearVehiculo(){

            ArrayList<BuildingManager> talleres;
            int opcion = this.elegirVehiculo();
            int subOpcion, newCant;
            AbstractFactory fabrica = FactoryProducer.getFactory(Type.MACHINE);
            MachineManager temp;
            String msj;
            boolean verificarRecursos, verificarConstruccion = true;

            switch(opcion){
                case 1:
                   subOpcion = this.validarEleccion(this.razaDisponible.getVehiculosDisponibles().get(0));
                   switch(subOpcion){
                       case 1:
                            talleres = this.buscarEdificio(Type.HUESERA);
                            if(!talleres.isEmpty()){
                                for (BuildingManager edificio : talleres){
                                 verificarConstruccion = verificarConstruccion && edificio.isIsEnable();
                                }
                                if(verificarConstruccion){
                                    verificarRecursos = this.verificarRecursos(this.razaDisponible.getVehiculosDisponibles().get(0));
                                    if(verificarRecursos){
                                         temp = fabrica.getMachine(this.razaDisponible.getVehiculosDisponibles().get(0));
                                         temp.setCreationFase(this.faseActual);

                                         newCant = this.recursosDisponibles.get(this.razaDisponible.getVehiculosDisponibles().get(0).getRecurso1()) - this.razaDisponible.getVehiculosDisponibles().get(0).getCostR1();
                                         this.recursosDisponibles.put(this.razaDisponible.getVehiculosDisponibles().get(0).getRecurso1(), newCant);
                                         newCant = this.recursosDisponibles.get(this.razaDisponible.getVehiculosDisponibles().get(0).getRecurso2()) - this.razaDisponible.getVehiculosDisponibles().get(0).getCostR2();
                                         this.recursosDisponibles.put(this.razaDisponible.getVehiculosDisponibles().get(0).getRecurso2(), newCant);

                                         msj = this.razaDisponible.getVehiculosDisponibles().get(0).getNombre() +" se estan construyendo \n Fases a esperar: " + temp.getWaitTime() +"\n";
                                         this.vehiculosPreparados.add(temp);
                                         JOptionPane.showMessageDialog(null,msj);
                                    }else{
                                         msj = "Recursos Insuficientes para construir " +this.razaDisponible.getTropasDisponibles().get(0).getNombre();
                                         JOptionPane.showMessageDialog(null,msj);
                                    }
                                }else{
                                   System.out.println("No se puede crear... Huesera en construccion");
                                }
                            }else{
                                msj = "¡No se puede construir vehiculo! \n Primero construya una Huesera";
                                JOptionPane.showMessageDialog(null,msj);
                            }

                            break;
                       default:
                           msj = "Construccion cancelada";
                           JOptionPane.showMessageDialog(null,msj);
                           break;
                   }
                    break;
                case 2:
                    subOpcion = this.validarEleccion(this.razaDisponible.getVehiculosDisponibles().get(1));
                    switch(subOpcion){
                        case 1:
                            talleres = this.buscarEdificio(Type.TALLER);
                                if(!talleres.isEmpty()){
                                    for (BuildingManager edificio : talleres){
                                     verificarConstruccion = verificarConstruccion && edificio.isIsEnable();
                                    }

                                    if(verificarConstruccion){
                                      verificarRecursos = this.verificarRecursos(this.razaDisponible.getVehiculosDisponibles().get(1));
                                      if(verificarRecursos){
                                           temp = fabrica.getMachine(this.razaDisponible.getVehiculosDisponibles().get(1));
                                           temp.setCreationFase(this.faseActual);

                                           newCant = this.recursosDisponibles.get(this.razaDisponible.getVehiculosDisponibles().get(1).getRecurso1()) - this.razaDisponible.getVehiculosDisponibles().get(1).getCostR1();
                                           this.recursosDisponibles.put(this.razaDisponible.getVehiculosDisponibles().get(1).getRecurso1(), newCant);
                                           newCant = this.recursosDisponibles.get(this.razaDisponible.getVehiculosDisponibles().get(1).getRecurso2()) - this.razaDisponible.getVehiculosDisponibles().get(1).getCostR2();
                                           this.recursosDisponibles.put(this.razaDisponible.getVehiculosDisponibles().get(1).getRecurso2(), newCant);

                                           msj = this.razaDisponible.getVehiculosDisponibles().get(1).getNombre() +" se estan construyendo \n Fases a esperar: " + temp.getWaitTime() +"\n";
                                           this.vehiculosPreparados.add(temp);
                                           JOptionPane.showMessageDialog(null,msj);
                                      }else{
                                           msj = "Recursos Insuficientes para construir " +this.razaDisponible.getVehiculosDisponibles().get(1).getNombre();
                                           JOptionPane.showMessageDialog(null,msj);
                                      }
                                  }else{
                                    System.out.println("No se puede crear... Taller en construccion");
                                  }
                                }else{
                                    msj = "¡No se puede construir vehiculo! \n Primero construya una Taller";
                                    JOptionPane.showMessageDialog(null,msj);
                                }
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }

    }

    public void verificarUso(){
        for (BuildingManager edificacion : this.edificiosConstruidos){
            if((edificacion.getCreationFase()+edificacion.getWaitTime()) == this.faseActual){
                edificacion.setIsEnable(true);
                System.out.println(edificacion.getNombre() + " esta listo para ser utilizado");
            }
        }

        for (ArmyManager ejercito : this.tropasPreparadas){
            if((ejercito.getCreationFase()+ejercito.getWaitTime()) == this.faseActual){
                ejercito.setIsEnable(true);
                System.out.println(ejercito.getNombre() + " esta listo para atacar");
            }
        }

        for (MachineManager vehiculo : this.vehiculosPreparados){
            if((vehiculo.getCreationFase()+vehiculo.getWaitTime()) == this.faseActual){
                vehiculo.setIsEnable(true);
                System.out.println(vehiculo.getNombre() + "esta listo para atacar");
            }
        }
    }

    @Override
    public void viewEdificios(){

        for (BuildingManager edificacion : this.edificiosConstruidos){
            if((edificacion.getCreationFase()+edificacion.getWaitTime()) <= this.faseActual){
                System.out.println(edificacion.getNombre() + " \tEstado: Disponible" + " \tVida: " + edificacion.getVida());
            }else{
                System.out.println(edificacion.getNombre() + " \tEstado: En Proceso" + " \tVida: " + edificacion.getVida());

            }
        }
    }

        @Override
    public void viewTropas(){

        for (ArmyManager tropa : this.tropasPreparadas){
            if((tropa.getCreationFase()+tropa.getWaitTime()) <= this.faseActual){
                System.out.println(tropa.getNombre() + " \tEstado: Disponible" + " \tVida: " + tropa.getVida());
            }else{
                System.out.println(tropa.getNombre() + " \tEstado: En Proceso" + " \tVida: " + tropa.getVida());

            }
        }
    }

    @Override
    public void viewVehiculos(){

        for (MachineManager vehiculo : this.vehiculosPreparados){
            if((vehiculo.getCreationFase()+ vehiculo.getWaitTime()) <= this.faseActual){
                System.out.println(vehiculo.getNombre() + " \tEstado: Disponible" + " \tVida: " + vehiculo.getVida());
            }else{
                System.out.println(vehiculo.getNombre() + " \tEstado: En Proceso" + " \tVida: " + vehiculo.getVida());

            }
        }
    }

    public void mejorarCentroDemando(){
        int[] newCost = new int[3];
        int[] available = new int[3];
        int opcion;
        Scanner leer = new Scanner(System.in);
        CentroDeMando c = this.centroDeMando;

        newCost[0] = (int)((double) c.getMaxCapacity().get(Type.ORO) * 0.25);
        newCost[1] = (int)((double) c.getMaxCapacity().get(Type.DIAMANTES) * 0.25);
        newCost[2] = (int)((double) c.getMaxCapacity().get(Type.ZAFIRO) * 0.25);

        available[0] = this.recursosDisponibles.get(Type.ORO);
        available[1] = this.recursosDisponibles.get(Type.DIAMANTES);
        available[2] = this.recursosDisponibles.get(Type.ZAFIRO);

        boolean verificacion = (newCost[0] <= available[0] &&
                                newCost[1] <= available[1] &&
                                newCost[0] <= available[2]);
        if(verificacion){
            System.out.println("Costo de mejora del Centro de Mando:");
            System.out.println("Oro: " + newCost[0] + "\t" + "Diamantes: " + newCost[1] + "\t" + "Zafiro: " + newCost[2]);

            System.out.println("Desea mejorar: (1. Si <-> 2.No)");
            try{
                opcion = leer.nextInt();
                switch(opcion){
                    case 1:
                        c.mejorarCentroDeMando();
                        this.recursosDisponibles.put(Type.ORO, (available[0]-newCost[0]));
                        this.recursosDisponibles.put(Type.DIAMANTES, (available[1]-newCost[1]));
                        this.recursosDisponibles.put(Type.ZAFIRO, (available[2]-newCost[2]));
                        System.out.println("Mejora realizada con exito");
                        break;
                    case 2:
                        System.err.println("Mejora cancelada");
                        break;
                    default:
                        System.err.println("Opcion no valida");
                        break;
                }
            }catch(NumberFormatException e) {
                System.err.println("Opcion no valida");
            }
        }else{
            System.err.println("Recursos insuficientes para mejorar el Centro de mando ");
        }
    }

    public void recolectarOro(){

        ArrayList<BuildingManager> recolectoresOro = this.buscarEdificio(Type.MINADEORO);
        String msj;
        MinaDeOro minaDeOro = new MinaDeOro();
        int recurso;
        int fases=0;

        if(!recolectoresOro.isEmpty()){
             for (BuildingManager edificio : recolectoresOro){
                 if(edificio.isIsEnable()){
                     fases = fases + (this.faseActual - edificio.getRecolectionFase());
                     edificio.setRecolectionFase(this.faseActual);
                 }else{
                     System.out.println("No se puede recolectar... Mina de Oro en construccion");
                 }
             }
             recurso = this.recursosDisponibles.get(Type.ORO) + (minaDeOro.getProduccionxfase() * fases * recolectoresOro.size());
            if(recurso <= this.centroDeMando.getMaxCapacity().get(Type.ORO)){
                this.recursosDisponibles.put(Type.ORO, recurso);
                msj = "Oro Recolectado con exito \n Oro: " + recurso;
                JOptionPane.showMessageDialog(null,msj);
            }else{
                this.recursosDisponibles.put(Type.ORO, this.centroDeMando.getMaxCapacity().get(Type.ORO));
                msj = "Oro Recolectado con exito \n Oro: " + this.centroDeMando.getMaxCapacity().get(Type.ORO)  + "\n Almacen de Oro a maxima Capacidad";
                JOptionPane.showMessageDialog(null,msj);
            }

        }
        else{
            msj = "¡No se puede recolectar Oro! \n Primero construya una Mina de Oro";
            JOptionPane.showMessageDialog(null,msj);
        }

    }

    public void recolectarDiamantes(){
        ArrayList<BuildingManager> recolectoresDiamantes = this.buscarEdificio(Type.MINADEDIAMANTE);
        String msj;
        MinaDeDiamante minaDeDiamante = new MinaDeDiamante();
        int recurso;
        int fases=0;

        if(!recolectoresDiamantes.isEmpty()){
             for (BuildingManager edificio : recolectoresDiamantes){
                 if(edificio.isIsEnable()){
                     fases = fases + (this.faseActual - edificio.getRecolectionFase());
                     edificio.setRecolectionFase(this.faseActual);
                 }else{
                     System.out.println("No se puede recolectar... Mina de Diamante en construccion");
                 }
             }
             recurso = this.recursosDisponibles.get(Type.DIAMANTES) + (minaDeDiamante.getProduccionxfase() * fases * recolectoresDiamantes.size());
            if(recurso <= this.centroDeMando.getMaxCapacity().get(Type.DIAMANTES)){
                this.recursosDisponibles.put(Type.DIAMANTES, recurso);
                msj = "Diamantes Recolectado con exito \n Diamantes: " + recurso;
                JOptionPane.showMessageDialog(null,msj);
            }else{
                this.recursosDisponibles.put(Type.DIAMANTES, this.centroDeMando.getMaxCapacity().get(Type.DIAMANTES));
                msj = "Diamantes Recolectado con exito \n Diamantes: " + this.centroDeMando.getMaxCapacity().get(Type.DIAMANTES) + "\n Almacen de Diamantes a maxima Capacidad";
                JOptionPane.showMessageDialog(null,msj);
            }

        }
        else{
            msj = "¡No se puede recolectar Diamantes! \n Primero construya una Mina de Diamantes";
            JOptionPane.showMessageDialog(null,msj);
        }
    }

    public void recolectarZafiro(){

        ArrayList<BuildingManager> extractoresZafiro = this.buscarEdificio(Type.EXTRACTORDEZAFIRO);
        String msj;
        ExtractorDeZafiro extractorDeZafiro = new ExtractorDeZafiro();
        int recurso;
        int fases=0;

        if(!extractoresZafiro.isEmpty()){
             for (BuildingManager edificio : extractoresZafiro){
                 if(edificio.isIsEnable()){
                     fases = fases + (this.faseActual - edificio.getRecolectionFase());
                     edificio.setRecolectionFase(this.faseActual);
                 }else{
                     System.out.println("No se puede recolectar... Extractor de Zafiro en construccion");
                 }
             }
             recurso = this.recursosDisponibles.get(Type.ZAFIRO) + (extractorDeZafiro.getProduccionxfase() * fases * extractoresZafiro.size());
            if(recurso <= this.centroDeMando.getMaxCapacity().get(Type.ZAFIRO)){
                this.recursosDisponibles.put(Type.ZAFIRO, recurso);
                msj = "Zafiro Recolectado con exito \n Zafiro: " + recurso;
                JOptionPane.showMessageDialog(null,msj);
            }else{
                this.recursosDisponibles.put(Type.ZAFIRO, this.centroDeMando.getMaxCapacity().get(Type.ZAFIRO));
                msj = "Zafiro Recolectado con exito \n Zafiro: " + this.centroDeMando.getMaxCapacity().get(Type.DIAMANTES) + "\n Almacen de Zafiro a maxima Capacidad";
                JOptionPane.showMessageDialog(null,msj);
            }

        }
        else{
            msj = "¡No se puede recolectar Diamantes! \n Primero construya una Mina de Diamantes";
            JOptionPane.showMessageDialog(null,msj);
        }
    }

    public int elegirTropaParaAtacar(){
        String disponibles = "Tropas disponibles: \n";
        ArrayList<ArmyManager> tropas = new ArrayList<>();
        int opcion, i = 1;

        for (ArmyManager tropa : this.tropasPreparadas) {
          if((tropa.getCreationFase()+tropa.getWaitTime()) <= this.faseActual){
            disponibles = disponibles + (i) + ". " + tropa.getNombre() + " Ataque: " + tropa.getAttackPower + "\n";
            tropas.add(tropa);
            i = i + 1;
        }

        try {
          if(!tropa.isEmpty()){
            opcion = Integer.parseInt(JOptionPane.showInputDialog(disponibles, null));
          }else{
            msj = "¡Tropas en preparcion! \n Espere a que las tropas esten disponibles para atacar";
            JOptionPane.showMessageDialog(null,msj);
            opcion = -1;
          }

        }catch(NumberFormatException e){
            opcion = -1;
        }
        return opcion;
    }

    public void elegirEdificioAAtacar(AldeaManager aldeaEnemiga){

        for (BuildingManager edificacion : this.edificiosConstruidos){
            if((edificacion.getCreationFase()+edificacion.getWaitTime()) <= this.faseActual){
                System.out.println(edificacion.getNombre() + " \tEstado: Disponible" + " \tVida: " + edificacion.getVida());
            }else{
                System.out.println(edificacion.getNombre() + " \tEstado: En Proceso" + " \tVida: " + edificacion.getVida());

            }
        }
    }

    public void realizarAtaque(AldeManager aldeaEnemiga){
      int posicionTropa = this.elegirTropaParaAtacar()-1;


    }

    public void avanzarFase(){
        this.faseActual += 1;
    }

    public void turno(AldeaManager aldeaEnemiga){
        int opcion = 0, subOption =0;
        while(opcion != 4){

            String encabezado = "Turno de "+ this.nombreJugador + " \n" +
                                Type.ORO.getNombre()+ ": " + this.recursosDisponibles.get(Type.ORO) +"\n" +
                                Type.DIAMANTES.getNombre() + ": " + this.recursosDisponibles.get(Type.DIAMANTES) +"\n" +
                                Type.ZAFIRO.getNombre() + ": " + this.recursosDisponibles.get(Type.ZAFIRO) +"\n"+
                                "Fase: " + this.faseActual;
            JOptionPane.showMessageDialog(null,encabezado);

            System.out.println("<================= Turno de " + this.nombreJugador + " =================>");
            System.out.println(Type.ORO.getNombre() + ": "+ this.recursosDisponibles.get(Type.ORO)+ "\t" + Type.DIAMANTES.getNombre() + ": " + this.recursosDisponibles.get(Type.DIAMANTES) + "\t  \t" + Type.ZAFIRO.getNombre() + ": " + this.recursosDisponibles.get(Type.ZAFIRO));

            opcion = m.generalOptions();

            switch(opcion){
                case 1:
                    subOption = m.buildingOptions();
                    switch(subOption){
                        case 1:
                            System.out.println("<========================== Mejorar Centro de Mando ==========================>\n");
                            System.out.println(Type.ORO.getNombre() + ": "+ this.recursosDisponibles.get(Type.ORO)+ "\t" + Type.DIAMANTES.getNombre() + ": " + this.recursosDisponibles.get(Type.DIAMANTES) + "\t  \t" + Type.ZAFIRO.getNombre() + ": " + this.recursosDisponibles.get(Type.ZAFIRO));

                            this.mejorarCentroDemando();
                            break;
                        case 2:
                            System.out.println("<========================== Construir Estructuras ==========================>\n");
                            System.out.println(Type.ORO.getNombre() + ": "+ this.recursosDisponibles.get(Type.ORO)+ "\t" + Type.DIAMANTES.getNombre() + ": " + this.recursosDisponibles.get(Type.DIAMANTES) + "\t  \t" + Type.ZAFIRO.getNombre() + ": " + this.recursosDisponibles.get(Type.ZAFIRO));

                            this.construirEdificio();
                            break;
                        case 3:
                            System.out.println("<========================== Estructuras Construidas ==========================>\n");
                            System.out.println(Type.ORO.getNombre() + ": "+ this.recursosDisponibles.get(Type.ORO)+ "\t" + Type.DIAMANTES.getNombre() + ": " + this.recursosDisponibles.get(Type.DIAMANTES) + "\t  \t" + Type.ZAFIRO.getNombre() + ": " + this.recursosDisponibles.get(Type.ZAFIRO));
                            this.viewEdificios();
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    subOption = m.armyOptions();
                    switch(subOption){
                        case 1:
                            System.out.println("<========================== Entrenar Tropa ==========================>\n");
                            System.out.println(Type.ORO.getNombre() + ": "+ this.recursosDisponibles.get(Type.ORO)+ "\t" + Type.DIAMANTES.getNombre() + ": " + this.recursosDisponibles.get(Type.DIAMANTES) + "\t  \t" + Type.ZAFIRO.getNombre() + ": " + this.recursosDisponibles.get(Type.ZAFIRO));
                            this.entrenarTropa();
                            break;

                        case 2:
                            System.out.println("<========================== Crear Vehiculo ==========================>\n");
                            System.out.println(Type.ORO.getNombre() + ": "+ this.recursosDisponibles.get(Type.ORO)+ "\t" + Type.DIAMANTES.getNombre() + ": " + this.recursosDisponibles.get(Type.DIAMANTES) + "\t  \t" + Type.ZAFIRO.getNombre() + ": " + this.recursosDisponibles.get(Type.ZAFIRO));
                            this.crearVehiculo();
                            break;

                        case 3:
                            System.out.println("<========================== Mostrar Tropas Entrenadas ==========================>\n");
                            System.out.println(Type.ORO.getNombre() + ": "+ this.recursosDisponibles.get(Type.ORO)+ "\t" + Type.DIAMANTES.getNombre() + ": " + this.recursosDisponibles.get(Type.DIAMANTES) + "\t  \t" + Type.ZAFIRO.getNombre() + ": " + this.recursosDisponibles.get(Type.ZAFIRO));
                            System.out.println("Tropas Entrenadas: ");
                            this.viewEdificios();
                            System.out.println("Vehiculos Entrenados ");
                            this.viewVehiculos();
                            this.viewTropas();
                            break;
                        case 4:
                            System.out.println("<========================== Atacar ==========================>\n");
                            System.out.println(Type.ORO.getNombre() + ": "+ this.recursosDisponibles.get(Type.ORO)+ "\t" + Type.DIAMANTES.getNombre() + ": " + this.recursosDisponibles.get(Type.DIAMANTES) + "\t  \t" + Type.ZAFIRO.getNombre() + ": " + this.recursosDisponibles.get(Type.ZAFIRO));
                            this.realizarAtaque(aldeaEnemiga);
                            break;
                        case 5:
                            System.out.println("<========================== Defender ==========================>\n");
                            System.out.println(Type.ORO.getNombre() + ": "+ this.recursosDisponibles.get(Type.ORO)+ "\t" + Type.DIAMANTES.getNombre() + ": " + this.recursosDisponibles.get(Type.DIAMANTES) + "\t  \t" + Type.ZAFIRO.getNombre() + ": " + this.recursosDisponibles.get(Type.ZAFIRO));

                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    subOption = m.resourcesOptions();
                    switch(subOption){
                        case 1:
                            System.out.println("<========================== Recolectar Zafiro ==========================>\n");
                            System.out.println(Type.ORO.getNombre() + ": "+ this.recursosDisponibles.get(Type.ORO)+ "\t" + Type.DIAMANTES.getNombre() + ": " + this.recursosDisponibles.get(Type.DIAMANTES) + "\t  \t" + Type.ZAFIRO.getNombre() + ": " + this.recursosDisponibles.get(Type.ZAFIRO));
                            this.recolectarZafiro();
                            break;
                        case 2:
                            System.out.println("<========================== Almacenar Oro ==========================>\n");
                            System.out.println(Type.ORO.getNombre() + ": "+ this.recursosDisponibles.get(Type.ORO)+ "\t" + Type.DIAMANTES.getNombre() + ": " + this.recursosDisponibles.get(Type.DIAMANTES) + "\t  \t" + Type.ZAFIRO.getNombre() + ": " + this.recursosDisponibles.get(Type.ZAFIRO));
                            this.recolectarOro();
                            break;
                        case 3:
                            System.out.println("<========================== Almacenar Diamantes ==========================>\n");
                            System.out.println(Type.ORO.getNombre() + ": "+ this.recursosDisponibles.get(Type.ORO)+ "\t" + Type.DIAMANTES.getNombre() + ": " + this.recursosDisponibles.get(Type.DIAMANTES) + "\t  \t" + Type.ZAFIRO.getNombre() + ": " + this.recursosDisponibles.get(Type.ZAFIRO));
                            this.recolectarDiamantes();
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }

        System.out.println("Turno finalizado con exito!!!");
    }
}
