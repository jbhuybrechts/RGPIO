package devices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Device {

    public static HashMap<String, Device> MODELS = null;
    
    public static List<Device> DEVICES = new LinkedList<>();

    public String model = "";
    public String id = "";        // unique hardware identifier
    public long lastContact = 0; // timestamp
    public ArrayList<Pin> pins = new ArrayList<>();

    public static Device createDeviceModel(String name) {
        Device device = new Device();
        device.model = name;
        MODELS.put(name, device);
        return device;
    }

    public void addDigitalInput(String label) {
        Pin p = new Pin();
        p.pinType = PinType.DigitalInput;
        p.label = label;
        pins.add(p);
    }

    public void addDigitalOutput(String label) {
        Pin p = new Pin();
        p.pinType = PinType.DigitalOutput;
        p.label = label;
        pins.add(p);
    }

    public void addAnalogInput(String label) {
        Pin p = new Pin();
        p.pinType = PinType.AnalogInput;
        p.label = label;
        pins.add(p);
    }

    public void addAnalogOutput(String label) {
        Pin p = new Pin();
        p.pinType = PinType.AnalogOutput;
        p.label = label;
        pins.add(p);
    }

    public static Device addDevice(String modelName) {
        Device deviceModel = MODELS.get(modelName);
        Device device = new Device();
        DEVICES.add(device);
        device.model = deviceModel.model;
        for (Pin p : deviceModel.pins) {
            Pin pin = new Pin();
            pin.label = p.label;
            pin.pinType = p.pinType;
            device.pins.add(pin);
        }
        return device;

    }

}
