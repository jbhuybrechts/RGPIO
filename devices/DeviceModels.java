package devices;

import java.util.HashMap;

public class DeviceModels {
    
    public static HashMap<String, Device> MODELS = new HashMap<>();  // key is device model name 
    
    public static Device addDeviceModel(String name) {
        Device device = new Device();
        device.model = name;
        MODELS.put(name, device);
        return device;
    }

   static public Device getDeviceModel(String deviceModelName) {
        Device d = MODELS.get(deviceModelName);
        if (d==null){
            System.out.println("getDeviceModel(): no device model with name="+deviceModelName);
        }
        return d;
    }
}
