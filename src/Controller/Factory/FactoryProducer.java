
package Controller.Factory;

import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(Type type){
        switch(type){
            case ARMY:
                return new FactoryArmy();
            case BUILDING:
                return new FactoryBuilding();
            case MACHINE:
                return new FactoryMachine();
        }
        return null;
    }
}
