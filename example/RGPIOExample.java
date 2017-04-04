

package example;

import rgpio.DigitalPinStateChangeEvent;
import rgpio.DigitalPinStateChangeListener;
import rgpio.RGPIODispatcher;


public class RGPIOExample {

    

     
     public static void main(String args[]) throws Exception {
     
         RGPIODispatcher RGPIOd = new RGPIODispatcher();
         
         HandleStateChange h = new HandleStateChange();
         
         while (true){
             Thread.sleep(1000);
         }
     }
}
