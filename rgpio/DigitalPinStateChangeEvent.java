

package rgpio;


public class DigitalPinStateChangeEvent {
    
 public RGPIODigitalInputPin pin;
 public boolean state;
 
 public DigitalPinStateChangeEvent(RGPIODigitalInputPin pin, boolean state){
     this.pin=pin;
     this.state=state;
 }
 
}
