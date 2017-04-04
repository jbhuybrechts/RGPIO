/*
http://programming.guide/java/create-a-custom-event.html
 */
package rgpio;

import java.util.ArrayList;
import java.util.List;

public class RGPIODigitalInputPin extends RGPIODigitalPin {

    private List<DigitalPinStateChangeListener> listeners = new ArrayList<>();

    public void addListener(DigitalPinStateChangeListener toAdd) {
        listeners.add(toAdd);
    }

    public void stateChange(boolean newState) {
        System.out.println("RGPIODigitalInputPin new state=" + newState);

        // create an event and call all the listeners
        DigitalPinStateChangeEvent event = new DigitalPinStateChangeEvent(this, newState);
        for (DigitalPinStateChangeListener l : listeners) {
            l.doOnDigitalPinStateChange(event);
        }
    }
}
