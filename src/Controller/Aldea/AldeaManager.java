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
        this.recursosDisponibles.put(Type.ORO, 1750);
        this.recursosDisponibles.put(Type.DIAMANTES, 1000);
        this.recursosDisponibles.put(Type.ZAFIRO, 3000);
    
        this.faseActual = 0;
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
    
    public BuildingManager buscarEdificio(Type edificio) {
            for (BuildingManager edificacion : this.edificiosConstruidos) {                
                if (edificacion.getTipo().equals(edificio)) {
                    return edificacion;
                }
            }
        
        return null;
    }
    
    public int elegirTropa(){
        String disponibles = "Tropas disponibles: \n";
        int opcion;
          
        for (int i = 0; i <= this.razaDisponible.getTropasDisponibles().size()-1; i++) {
            disponibles = disponibles + i + ". " + this.razaDisponible.getTropasDisponibles().get(i).getNombre() + "\n";
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
        int opcion = this.elegirTropa();
        int subOpcion;
        AbstractFactory fabrica = FactoryProducer.getFactory(Type.ARMY);
        ArmyManager temp;
        String msj;
        boolean verificarRecursos;
        
        switch(opcion){
            case 1:
                   subOpcion = this.validarEleccion(Type.ARQUERAS);
                   switch(subOpcion){
                       case 1:
                            verificarRecursos = this.verificarRecursos(Type.ARQUERAS);
                            if(verificarRecursos){
                                 temp = fabrica.getArmy(Type.ARQUERAS);
                                 temp.setCreationFase(this.faseActual);
                                 msj = "Arqueras se estan entrenando \n Fases a esperar: " + temp.getWaitTime() +"\n";
                                 this.tropasPreparadas.add(temp);
                                 JOptionPane.showMessageDialog(null,msj);
                            }else{
                                 msj = "Recursos Insuficientes para entrenar arqueras";
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
                   subOpcion = this.validarEleccion(Type.VALQUIRIAS);
                   switch(subOpcion){
                       case 1:
                            verificarRecursos = this.verificarRecursos(Type.VALQUIRIAS);
                            if(verificarRecursos){
                                 temp = fabrica.getArmy(Type.VALQUIRIAS);
                                 temp.setCreationFase(this.faseActual);
                                 msj = "Valquirias se estan entrenando \n Fases a esperar: " + temp.getWaitTime() +"\n";
                                 this.tropasPreparadas.add(temp);
                                 JOptionPane.showMessageDialog(null,msj);
                            }else{
                                 msj = "Recursos Insuficientes para entrenar valquirias";
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
                   subOpcion = this.validarEleccion(Type.REINAARQUERA);
                   switch(subOpcion){
                       case 1:
                            verificarRecursos = this.verificarRecursos(Type.REINAARQUERA);
                            if(verificarRecursos){
                                 temp = fabrica.getArmy(Type.REINAARQUERA);
                                 temp.setCreationFase(this.faseActual);
                                 msj = "Reina Arquera se estan entrenando \n Fases a esperar: " + temp.getWaitTime() +"\n";
                                 this.tropasPreparadas.add(temp);
                                 JOptionPane.showMessageDialog(null,msj);
                            }else{
                                 msj = "Recursos Insuficientes para entrenar Reina Arquera";
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
            int subOpcion;
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
                                 msj = "Cuartel en construccion\n Fases a esperar: " + temp.getWaitTime() +"\n";
                                 this.edificiosConstruidos.add(temp);
                                 JOptionPane.showMessageDialog(null,msj);
                            }else{
                                 msj = "Recursos Insuficientes para construir el cuartel";
                                 JOptionPane.showMessageDialog(null,msj);
                            }
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
                                 msj = "Extractor de zafiro en construccion\n Fases a esperar: " + temp.getWaitTime() +"\n";
                                 this.edificiosConstruidos.add(temp);
                                 JOptionPane.showMessageDialog(null,msj);
                            }else{
                                 msj = "Recursos Insuficientes para construir el extractor de zafiro";
                                 JOptionPane.showMessageDialog(null,msj);
                            }
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
                                 msj = "Huesera en construccion\n Fases a esperar: " + temp.getWaitTime() +"\n";
                                 this.edificiosConstruidos.add(temp);
                                 JOptionPane.showMessageDialog(null,msj);
                            }else{
                                 msj = "Recursos Insuficientes para construir la huesera";
                                 JOptionPane.showMessageDialog(null,msj);
                            }
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
                                 msj = "Mina de diamante en construccion\n Fases a esperar: " + temp.getWaitTime() +"\n";
                                 this.edificiosConstruidos.add(temp);
                                 JOptionPane.showMessageDialog(null,msj);
                            }else{
                                 msj = "Recursos Insuficientes para construir la mina de diamante";
                                 JOptionPane.showMessageDialog(null,msj);
                            }
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
                                 msj = "Mina de Oro en construccion\n Fases a esperar: " + temp.getWaitTime() +"\n";
                                 this.edificiosConstruidos.add(temp);
                                 JOptionPane.showMessageDialog(null,msj);
                            }else{
                                 msj = "Recursos Insuficientes para construir la mina de oro";
                                 JOptionPane.showMessageDialog(null,msj);
                            }
                       default:
                           msj = "Construccion cancelada";
                           JOptionPane.showMessageDialog(null,msj);
                           break;
                   }
                case 6:
                   subOpcion = this.validarEleccion(Type.TALLER);
                   switch(subOpcion){
                       case 1:
                            verificarRecursos = this.verificarRecursos(Type.TALLER);
                            if(verificarRecursos){
                                 temp = fabrica.getBuilding(Type.TALLER);
                                 temp.setCreationFase(this.faseActual);
                                 msj = "Taller en construccion\n Fases a esperar: " + temp.getWaitTime() +"\n";
                                 this.edificiosConstruidos.add(temp);
                                 JOptionPane.showMessageDialog(null,msj);
                            }else{
                                 msj = "Recursos Insuficientes para construir el taller";
                                 JOptionPane.showMessageDialog(null,msj);
                            }
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
    
    /**
     * Agrega un vehiculo a lista de edificios
     */
    @Override
    public void crearVehiculo(){
        //Desde Cuartel
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
    
    public void avanzarFase(){
        this.faseActual += 1;
    }
    
    public void turno(){
        int opcion = 0, subOption =0;
        while(opcion != 4){
            
            String encabezado = "Turno de "+ this.nombreJugador + " \n" +
                                Type.ORO.getNombre()+ ": " + this.recursosDisponibles.get(Type.ORO) +"\n" +
                                Type.DIAMANTES.getNombre() + ": " + this.recursosDisponibles.get(Type.DIAMANTES) +"\n" +
                                Type.ZAFIRO.getNombre() + ": " + this.recursosDisponibles.get(Type.ZAFIRO) +"\n";
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
                            System.out.println("<========================== Mostrar Tropas Entrenadas ==========================>\n");
                            System.out.println(Type.ORO.getNombre() + ": "+ this.recursosDisponibles.get(Type.ORO)+ "\t" + Type.DIAMANTES.getNombre() + ": " + this.recursosDisponibles.get(Type.DIAMANTES) + "\t  \t" + Type.ZAFIRO.getNombre() + ": " + this.recursosDisponibles.get(Type.ZAFIRO));
                            
                            break;
                        case 3:
                            System.out.println("<========================== Atacar ==========================>\n");
                            System.out.println(Type.ORO.getNombre() + ": "+ this.recursosDisponibles.get(Type.ORO)+ "\t" + Type.DIAMANTES.getNombre() + ": " + this.recursosDisponibles.get(Type.DIAMANTES) + "\t  \t" + Type.ZAFIRO.getNombre() + ": " + this.recursosDisponibles.get(Type.ZAFIRO));

                            break;
                        case 4:
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

                            break;
                        case 2:
                            System.out.println("<========================== Almacenar Oro ==========================>\n");
                            System.out.println(Type.ORO.getNombre() + ": "+ this.recursosDisponibles.get(Type.ORO)+ "\t" + Type.DIAMANTES.getNombre() + ": " + this.recursosDisponibles.get(Type.DIAMANTES) + "\t  \t" + Type.ZAFIRO.getNombre() + ": " + this.recursosDisponibles.get(Type.ZAFIRO));

                            break;
                        case 3:
                            System.out.println("<========================== Almacenar Diamantes ==========================>\n");
                            System.out.println(Type.ORO.getNombre() + ": "+ this.recursosDisponibles.get(Type.ORO)+ "\t" + Type.DIAMANTES.getNombre() + ": " + this.recursosDisponibles.get(Type.DIAMANTES) + "\t  \t" + Type.ZAFIRO.getNombre() + ": " + this.recursosDisponibles.get(Type.ZAFIRO));

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
