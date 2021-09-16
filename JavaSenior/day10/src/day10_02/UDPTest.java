package day10_02;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * UDPЭ���������
 *
 * @acthor KKKKK
 * @creay 2021-04-28-{TIME}
 */
public class UDPTest
{
    //���Ͷ�
    @Test
    public void sender() throws IOException
    {
        DatagramSocket socket = new DatagramSocket();

        String str = "UDPЭ���������";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,9090);

        socket.send(packet);

        socket.close();
    }

    //���ն�
    @Test
    public void receiver() throws IOException
    {
        DatagramSocket socket = new DatagramSocket(9090);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));
    }
}
