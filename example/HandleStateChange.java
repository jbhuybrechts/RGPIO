

package example;

import devices.PinEventListener;
import devices.PinEvent;


public class HandleStateChange implements PinEventListener {
        public void onPinEvent(PinEvent event){
             System.out.println(" listener received pin event state="+event.state);
         }
     }
