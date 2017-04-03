package rgpio;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;

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
                InetAddress deviceIPAddress = receivePacket.getAddress();
                String s[] = message.split(" ");
                System.out.println("RECEIVED: " + message);
                System.out.println(" device=" + s[1]);
                System.out.println(" ip address=" + deviceIPAddress.toString());

                // send a reply with the ip address of the server
                // to find our own ip address, make a TCP connection 
                Socket probeSocket = new Socket(deviceIPAddress, 80);
                InetAddress myIPAddress = probeSocket.getLocalAddress();
                probeSocket.close();
                byte[] sendData = new byte[1024];
                sendData = myIPAddress.toString().getBytes();
                int port = receivePacket.getPort();
                DatagramPacket sendPacket
                        = new DatagramPacket(sendData, sendData.length, deviceIPAddress, port);
                serverSocket.send(sendPacket);
                String reply = new String(sendPacket.getData());
                System.out.println("SENT: " + reply);

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
