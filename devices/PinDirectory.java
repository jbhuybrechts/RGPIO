
package devices;

import rgpio.*;


public class PinDirectory {

    /* class that provides the interface to the available pins
       It maps a function identifier to a pin instance.
    
    */
    
    
    
    RGPIODigitalInputPin pin = new RGPIODigitalInputPin();

    public RGPIODigitalInputPin provisionDigitalInputPin() {
        return pin;
    }
}
