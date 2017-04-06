package devices;

import java.util.HashMap;

public class Devices {

  
    public static HashMap<String, Device> DEVICES = new HashMap<>();  // key is device instance name

 

    public static Device addDevice(String modelName, String deviceName) {

        Device model = DeviceModels.MODELS.get(modelName);
        Device device = new Device();
        DEVICES.put(deviceName, device);
        device.model = modelName;
        for (Pin p : model.pins.values()) {
            Pin pin = device.addPin(p.label);
            pin.pinType = p.pinType;
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

}
