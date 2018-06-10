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
    
    ESPECIALISTA(new TypeBuilder("Especialista")),
    AVENGERSOFARROW(new TypeBuilder("Vengadores de Flecha")),
    KNIGHTSOFTHESHADOWS(new TypeBuilder("Caballeros de la Sombra")),
    LOSGUERREROSZ(new TypeBuilder("Los Guerreros Z")),
    ORO(new TypeBuilder("Oro")),
    ZAFIRO(new TypeBuilder("Zafiro")),
    DIAMANTES(new TypeBuilder("Diamantes")),
    ARMY(new TypeBuilder("Ejercito")),
    BUILDING(new TypeBuilder("Edificaciones")),
    MACHINE(new TypeBuilder("Vehiculos")),
   
    ARQUERAS(new TypeBuilder("Arquera").tipo("Escuadron").vida(100).waitTime(1).recursoUno("Oro").recursoDos("Diamante").costR1(250).costR2(150).attackPower(25)); 

    private final String nombre;     //Requerido
    private final String tipo;       //Opcional
    private final String recurso1;   //Opcional
    private final String recurso2;   //Opcional
    private final int vida;          //Opcional
    private final int waitTime;      //Opcional
    private final int attackPower;   //Opcional
    private final int costR1;        //Opcional
    private final int costR2;        //Opcional
    
    //CONSTRUCTOR 
    private Type(TypeBuilder constructor){
        this.nombre = constructor.nombre;
        this.tipo = constructor.tipo;
        this.recurso1 = constructor.recurso1;
        this.recurso2 = constructor.recurso2;
        this.vida = constructor.vida;
        this.waitTime = constructor.waitTime;
        this.costR1 = constructor.costR1;
        this.costR2 = constructor.costR2;
        this.attackPower = constructor.attackPower;
        
    }

    // GETTER   
    public int getVida() {
        return vida;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getRecurso1() {
        return recurso1;
    }

    public String getRecurso2() {
        return recurso2;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getCostR1() {
        return costR1;
    }

    public int getCostR2() {
        return costR2;
    }
    
    //BUILDER
    public static class TypeBuilder{
            
        private final String nombre;     //Requerido
        private String tipo;       //Opcional
        private String recurso1;   //Opcional
        private String recurso2;   //Opcional
        private int vida;          //Opcional
        private int waitTime;      //Opcional
        private int attackPower;   //Opcional
        private int costR1;        //Opcional
        private int costR2;        //Opcional

        public TypeBuilder(String name){
            this.nombre = name;
        }
        
        public TypeBuilder tipo(String tipo){
            this.tipo = tipo;
            return this;
        }
        
        public TypeBuilder recursoUno(String recurso){
            this.recurso1 = recurso;
            return this;
        }
        
        public TypeBuilder recursoDos(String recurso){
            this.recurso2 = recurso;
            return this;
        }
        
        public TypeBuilder vida(int vida){
            this.vida = vida;
            return this;
        }
        
        public TypeBuilder waitTime(int tiempoEspera){
            this.waitTime = tiempoEspera;
            return this;
        }
        
        public TypeBuilder attackPower(int ataque){
            this.attackPower = ataque;
            return this;
        }
        
        public TypeBuilder costR1(int cost){
            this.costR1 = cost;
            return this;
        }
        
        public TypeBuilder costR2(int cost){
            this.costR2 = cost;
            return this;
        }
        

    }

}
