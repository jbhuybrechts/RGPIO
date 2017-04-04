/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devices;

import rgpio.*;

/**
 *
 * @author ervanden
 */
public class PinDirectory {

    RGPIODigitalInputPin pin = new RGPIODigitalInputPin();

    public RGPIODigitalInputPin provisionDigitalInputPin() {
        return pin;
    }
}
