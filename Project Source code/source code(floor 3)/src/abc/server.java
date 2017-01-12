/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abc;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
/**
 *
 * @author Santhosh Bharadwaj
 */
public class server {
public server(byte[] b1,byte [] flag) throws Exception
{  
DatagramSocket flagsocket= new DatagramSocket(3456);
byte[] sendData = new byte[1024];
 byte[] receiveData = new byte[1024];

//byte addr[]=new byte[]{(byte)192,(byte)168,1,36};
//InetAddress IPadd=InetAddress.getByAddress(addr);
DatagramPacket recvpkt=new DatagramPacket(receiveData,receiveData.length); 
flagsocket.receive(recvpkt);
System.out.println("from 4");
InetAddress IPadd=recvpkt.getAddress();
int port=recvpkt.getPort();
DatagramPacket sendpkt=new DatagramPacket(flag,flag.length,IPadd,port); 
flagsocket.send(sendpkt);

// int port;
 byte data[]=new byte[10]; 

//while(true)
//{
DatagramSocket serverSocket = new DatagramSocket(1236);
DatagramPacket receivePacket =new DatagramPacket(receiveData, receiveData.length);
serverSocket.receive(receivePacket);
//System.out.println("received");
//String sentence = new String(receivePacket.getData());
byte b[]=new byte[10];
b=receivePacket.getData();
System.out.println("EIP="+b[0]+" "+b[1]);
//b=ele.b1;how to assign value to this FIP
InetAddress IPAddress = receivePacket.getAddress();
port = receivePacket.getPort();
//System.out.println("hi");
//}
   
//String capitalizedSentence= sentence.toUpperCase();
//here data is the density array in form {source,density}
//sendData = capitalizedSentence.getBytes();
//data=b1;
//System.out.println("top="+(top+1));
//public void sending()throws Exception
//{
   // System.out.println("hi");
data=b1;
sendData=data;
DatagramPacket sendPacket =new DatagramPacket(sendData, sendData.length,IPAddress, port);
serverSocket.send(sendPacket);
/*if(b[1]!=3)
{

 }*/
//}
// serverSocket.close();
}        
}

