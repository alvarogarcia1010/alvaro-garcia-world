/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Raza;

import alvarogarciaworld.Type;

/**
 *
 * @author Alvaro García <alvarogarcia1010 at github.com>
 */
public class RazaProducer {
        public static RazaManager getFactory(Type type){
            switch (type){
                case AVENGERSOFARROW:
                    return new AvengersOfArrow();
                case KNIGHTSOFTHESHADOWS:
                    return new KnightsOfTheShadows();
                case LOSGUERREROSZ:    
                    return new LosGuerrerosZ();
            }
            return null;
}
}
