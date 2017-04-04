package example;

import rgpio.*;
import devices.*;

public class RGPIOExample {
    
    public static void main(String args[]) throws Exception {
        
        RGPIODispatcher RGPIOd = new RGPIODispatcher();
        
        HandleStateChange h = new HandleStateChange();
        
        PinDirectory pinDirectory = new PinDirectory();
        RGPIODigitalInputPin pin = pinDirectory.provisionDigitalInputPin();
        pin.addListener(h);
        
        while (true) {
            pin.stateChange(true);
            Thread.sleep(5000);
            pin.stateChange(false);
            Thread.sleep(5000);
        }
    }
}
