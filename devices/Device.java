package devices;

import java.util.HashMap;

public class Device {

  
    public static HashMap<String, Device> DEVICES = new HashMap<>();  // key is device instance name

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

    public static Device addDevice(String modelName, String deviceName) {

        Device model = DeviceModels.MODELS.get(modelName);
        Device device = new Device();
        DEVICES.put(deviceName, device);
        device.model = modelName;
        for (Pin p : model.pins.values()) {
            Pin pin = device.addPin(p.label);
            pin.pinType = p.pinType;
            pin.device=device;
        }
        return device;

    }

    static public Device getDevice(String deviceName) {
        Device d = DEVICES.get(deviceName);
        if (d==null){
            System.out.println("getDeviceByName(): no device with name="+deviceName);
        }
        return d;
    }

    public Pin getPin(String pinLabel) {
        Pin p = pins.get(pinLabel);
         if (p==null){
            System.out.println("getPinByLabel(): device "+model+" has no pin with label="+pinLabel);
        }       
        return p;
    }

}
