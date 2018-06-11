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
   
    REINAARQUERA(new TypeBuilder("Reina Arquera").tipo("Especialista").vida(300).waitTime(3).recursoUno("Zafiro").recursoDos("Diamante").costR1(500).costR2(250).attackPower(100)),
    ARQUERAS(new TypeBuilder("Arquera").tipo("Escuadron").vida(100).waitTime(1).recursoUno("Oro").recursoDos("Diamante").costR1(250).costR2(150).attackPower(25)),
    VALQUIRIAS(new TypeBuilder("Valquiria").tipo("Escuadron").vida(150).waitTime(2).recursoUno("Oro").recursoDos("Diamante").costR1(300).costR2(200).attackPower(50)),
   
    BLACKWINDOW(new TypeBuilder("Black Windows").tipo("Vehiculo").vida(175).waitTime(2).recursoUno("Zafiro").recursoDos("Oro").costR1(400).costR2(250).attackPower(75)),
    STARKMACHINE(new TypeBuilder("Stark Machine").tipo("Vehiculo").vida(125).waitTime(1).recursoUno("Zafiro").recursoDos("Oro").costR1(350).costR2(150).attackPower(50)),
    
    CENTRODEMANDO(new TypeBuilder("Centro de Mando").tipo("Edificio").vida(500).waitTime(0).recursoUno("Zafiro").recursoDos("Diamante")),
    MINADEDIAMANTE(new TypeBuilder("Mina de Diamante").tipo("Edificio").vida(150).waitTime(1).recursoUno("Zafiro").recursoDos("Oro").costR1(1500).costR2(750)),
    MINADEORO(new TypeBuilder("Mina de Oro").tipo("Edificio").vida(150).waitTime(1).recursoUno("Zafiro").recursoDos("Diamante").costR1(1500).costR2(750)),
    EXTRACTORDEZAFIRO(new TypeBuilder("Extracto de Zafiro").tipo("Edificio").vida(250).waitTime(1).recursoUno("Oro").recursoDos("Diamante").costR1(1000).costR2(1000)),
    CUARTEL(new TypeBuilder("Cuartel").tipo("Edificio").vida(300).waitTime(2).recursoUno("Oro").recursoDos("Diamante").costR1(750).costR2(750)),
    HUESERA(new TypeBuilder("Huesera").tipo("Edificio").vida(300).waitTime(2).recursoUno("Zafiro").recursoDos("Diamante").costR1(900).costR2(500)),
    TALLER(new TypeBuilder("Taller").tipo("Edificio").vida(300).waitTime(2).recursoUno("Zafiro").recursoDos("Oro").costR1(900).costR2(500)),
     
    GRANCENTINELA(new TypeBuilder("Gran Centinela").tipo("Especialista").vida(350).waitTime(3).recursoUno("Zafiro").recursoDos("Diamante").costR1(600).costR2(400).attackPower(150)),
    MONTAPUERCOS(new TypeBuilder("Montapuercos").tipo("Escuadron").vida(225).waitTime(2).recursoUno("Oro").recursoDos("Diamante").costR1(300).costR2(300).attackPower(75)),
    BOMBARDEROS(new TypeBuilder("Bombarderos").tipo("Escuadron").vida(175).waitTime(1).recursoUno("Oro").recursoDos("Diamante").costR1(200).costR2(250).attackPower(50)),
   
    DEATHCAR(new TypeBuilder("Death Car").tipo("Vehiculo").vida(200).waitTime(2).recursoUno("Zafiro").recursoDos("Oro").costR1(400).costR2(200).attackPower(125)),
    LEGENDARYMACHINE(new TypeBuilder("Legendary Machine").tipo("Vehiculo").vida(250).waitTime(1).recursoUno("Zafiro").recursoDos("Oro").costR1(350).costR2(150).attackPower(100)),
   
    REYBARBARO(new TypeBuilder("Rey Barbaro").tipo("Especialista").vida(400).waitTime(3).recursoUno("Zafiro").recursoDos("Diamante").costR1(750).costR2(500).attackPower(200)),
    BARBAROS(new TypeBuilder("Barbaros").tipo("Escuadron").vida(250).waitTime(2).recursoUno("Oro").recursoDos("Diamante").costR1(600).costR2(400).attackPower(100)),
    LANZARROCAS(new TypeBuilder("Lanzarrocas").tipo("Escuadron").vida(200).waitTime(1).recursoUno("Oro").recursoDos("Diamante").costR1(400).costR2(400).attackPower(75)),
   
    WARMACHINE(new TypeBuilder("War Machine").tipo("Vehiculo").vida(275).waitTime(2).recursoUno("Zafiro").recursoDos("Oro").costR1(450).costR2(550).attackPower(150)),
    GHOSTCAR(new TypeBuilder("Ghost Car").tipo("Vehiculo").vida(275).waitTime(1).recursoUno("Zafiro").recursoDos("Oro").costR1(400).costR2(600).attackPower(150));

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
