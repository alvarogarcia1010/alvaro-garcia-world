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
   
    REINAARQUERA(new TypeBuilder("Reina Arquera").tipo("Especialista").vida(300).waitTime(3).recursoUno(Type.ZAFIRO).recursoDos(Type.DIAMANTES).costR1(500).costR2(250).attackPower(300)),
    ARQUERAS(new TypeBuilder("Arquera").tipo("Escuadron").vida(100).waitTime(1).recursoUno(Type.ORO).recursoDos(Type.DIAMANTES).costR1(250).costR2(150).attackPower(100)),
    VALQUIRIAS(new TypeBuilder("Valquiria").tipo("Escuadron").vida(150).waitTime(2).recursoUno(Type.ORO).recursoDos(Type.DIAMANTES).costR1(300).costR2(200).attackPower(150)),
   
    BLACKWINDOW(new TypeBuilder("Black Windows").tipo("Vehiculo").vida(175).waitTime(2).recursoUno(Type.ZAFIRO).recursoDos(Type.ORO).costR1(400).costR2(250).attackPower(200)),
    STARKMACHINE(new TypeBuilder("Stark Machine").tipo("Vehiculo").vida(125).waitTime(1).recursoUno(Type.ZAFIRO).recursoDos(Type.ORO).costR1(350).costR2(150).attackPower(150)),
    
    CENTRODEMANDO(new TypeBuilder("Centro de Mando").tipo("Edificio").vida(500).waitTime(0).recursoUno(Type.ZAFIRO).recursoDos(Type.DIAMANTES)),
    MINADEDIAMANTE(new TypeBuilder("Mina de Diamante").tipo("Edificio").vida(150).waitTime(1).recursoUno(Type.ZAFIRO).recursoDos(Type.ORO).costR1(1500).costR2(750)),
    MINADEORO(new TypeBuilder("Mina de Oro").tipo("Edificio").vida(150).waitTime(1).recursoUno(Type.ZAFIRO).recursoDos(Type.DIAMANTES).costR1(1500).costR2(750)),
    EXTRACTORDEZAFIRO(new TypeBuilder("Extracto de Zafiro").tipo("Edificio").vida(250).waitTime(1).recursoUno(Type.ORO).recursoDos(Type.DIAMANTES).costR1(1000).costR2(1000)),
    CUARTEL(new TypeBuilder("Cuartel").tipo("Edificio").vida(300).waitTime(2).recursoUno(Type.ORO).recursoDos(Type.DIAMANTES).costR1(750).costR2(750)),
    HUESERA(new TypeBuilder("Huesera").tipo("Edificio").vida(300).waitTime(2).recursoUno(Type.ZAFIRO).recursoDos(Type.DIAMANTES).costR1(900).costR2(500)),
    TALLER(new TypeBuilder("Taller").tipo("Edificio").vida(300).waitTime(2).recursoUno(Type.ZAFIRO).recursoDos(Type.ORO).costR1(900).costR2(500)),
     
    GRANCENTINELA(new TypeBuilder("Gran Centinela").tipo("Especialista").vida(350).waitTime(3).recursoUno(Type.ZAFIRO).recursoDos(Type.DIAMANTES).costR1(600).costR2(400).attackPower(450)),
    MONTAPUERCOS(new TypeBuilder("Montapuercos").tipo("Escuadron").vida(225).waitTime(2).recursoUno(Type.ORO).recursoDos(Type.DIAMANTES).costR1(300).costR2(300).attackPower(175)),
    BOMBARDEROS(new TypeBuilder("Bombarderos").tipo("Escuadron").vida(175).waitTime(1).recursoUno(Type.ORO).recursoDos(Type.DIAMANTES).costR1(200).costR2(250).attackPower(250)),
   
    DEATHCAR(new TypeBuilder("Death Car").tipo("Vehiculo").vida(200).waitTime(2).recursoUno(Type.ZAFIRO).recursoDos(Type.ORO).costR1(400).costR2(200).attackPower(325)),
    LEGENDARYMACHINE(new TypeBuilder("Legendary Machine").tipo("Vehiculo").vida(250).waitTime(1).recursoUno(Type.ZAFIRO).recursoDos(Type.ORO).costR1(350).costR2(150).attackPower(300)),
   
    REYBARBARO(new TypeBuilder("Rey Barbaro").tipo("Especialista").vida(400).waitTime(3).recursoUno(Type.ZAFIRO).recursoDos(Type.DIAMANTES).costR1(750).costR2(500).attackPower(400)),
    BARBAROS(new TypeBuilder("Barbaros").tipo("Escuadron").vida(250).waitTime(2).recursoUno(Type.ORO).recursoDos(Type.DIAMANTES).costR1(600).costR2(400).attackPower(200)),
    LANZARROCAS(new TypeBuilder("Lanzarrocas").tipo("Escuadron").vida(200).waitTime(1).recursoUno(Type.ORO).recursoDos(Type.DIAMANTES).costR1(400).costR2(400).attackPower(175)),
   
    WARMACHINE(new TypeBuilder("War Machine").tipo("Vehiculo").vida(275).waitTime(2).recursoUno(Type.ZAFIRO).recursoDos(Type.ORO).costR1(450).costR2(550).attackPower(250)),
    GHOSTCAR(new TypeBuilder("Ghost Car").tipo("Vehiculo").vida(275).waitTime(1).recursoUno(Type.ZAFIRO).recursoDos(Type.ORO).costR1(400).costR2(600).attackPower(300));

    private final String nombre;     //Requerido
    private final String tipo;       //Opcional
    private final Type recurso1;   //Opcional
    private final Type recurso2;   //Opcional
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

    public Type getRecurso1() {
        return recurso1;
    }

    public Type getRecurso2() {
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
        private Type recurso1;   //Opcional
        private Type recurso2;   //Opcional
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
        
        public TypeBuilder recursoUno(Type recurso){
            this.recurso1 = recurso;
            return this;
        }
        
        public TypeBuilder recursoDos(Type recurso){
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
