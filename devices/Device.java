package devices;

import java.util.HashMap;

public class Device {

    public String model = "";
    public String id = "";        // unique hardware identifier
    public long lastContact = 0; // timestamp
    public HashMap<String, Pin> pins = new HashMap<>();

        public Pin addPin(String label) {
        Pin p = new Pin();
        p.label = label;
        pins.put(label, p);
        return p;
    }
        
            public void addDigitalInput(String label) {
        Pin p = addPin(label);
        p.pinType = PinType.DigitalInput;
    }

    public void addDigitalOutput(String label) {
        Pin p = addPin(label);
        p.pinType = PinType.DigitalOutput;
    }

    public void addAnalogInput(String label) {
        Pin p = addPin(label);
        p.pinType = PinType.AnalogInput;
    }

    public void addAnalogOutput(String label) {
        Pin p = addPin(label);
        p.pinType = PinType.AnalogOutput;
    }

    public Pin getPin(String pinLabel) {
        Pin p = pins.get(pinLabel);
         if (p==null){
            System.out.println("getPinByLabel(): device "+model+" has no pin with label="+pinLabel);
        }       
        return p;
    }

}
