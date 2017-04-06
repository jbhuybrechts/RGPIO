package devices;

import java.util.ArrayList;
import java.util.List;

public class Pin {

    public PinType pinType;
    public String label;
    public Device device;

    private List<PinEventListener> listeners = new ArrayList<>();

    public void addListener(PinEventListener toAdd) {
        listeners.add(toAdd);
    }

    // xxxChange methods create an event and call all the listeners
    public void stateChange(boolean newState) {
        System.out.println("Pin new state=" + newState);

        PinEvent event = new PinEvent(this);
        event.state = newState;
        for (PinEventListener l : listeners) {
            l.onPinEvent(event);
        }
    }

    public void valueChange(double newValue) {
        System.out.println("Pin new value=" + newValue);

        PinEvent event = new PinEvent(this);
        event.value = newValue;
        for (PinEventListener l : listeners) {
            l.onPinEvent(event);
        }
    }

}
