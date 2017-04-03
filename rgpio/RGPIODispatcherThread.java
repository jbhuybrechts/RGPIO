package rgpio;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class RGPIODispatcherThread extends Thread {

    /* listens to UDP port 4455 for messages from remote devices.
     The message contains the device unique identifier and ip address.
     First message : the function id of the device pins needs to be determined
     Following messages : the arrival time of the messages is stored
     */
    public RGPIODispatcherThread() {
        super("RGPIODispatcherThread");
    }

    public void run() {
        try {
            DatagramSocket serverSocket = new DatagramSocket(4455);
            byte[] receiveData = new byte[1024];
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String message = new String(receivePacket.getData());
                System.out.println("RECEIVED: " + message);
                String s[] = message.split(" ");
                InetAddress deviceIPAddress = receivePacket.getAddress();
            }
        } catch (SocketException e) {
            System.out.println("RGPIODispatcherThread error during socket creation.");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("RGPIODispatcherThread error during socket.receive.");
            System.exit(-1);
        };

    }

}
