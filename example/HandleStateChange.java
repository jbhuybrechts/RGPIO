

package example;

import rgpio.*;


public class HandleStateChange implements DigitalPinStateChangeListener {
        public void doOnDigitalPinStateChange(DigitalPinStateChangeEvent event){
             System.out.println("received DigitalPinStateChange state="+event.pin);
         }
     }
