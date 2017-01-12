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
import java.net.UnknownHostException;

/**
 *
 * @author ThinkPad
 */
public class client
{
    int TAF=0,TBF=0;
    byte[] fcurr=new byte[10];

    //public static void main(String args[]) throws Exception
public client(byte[] flag,byte[] c) throws SocketException,UnknownHostException,IOException
    {
 //to send data to another laptop create socket in other laptop with portno and use that same port no in the send method of this laptop.
        //elevtor is present in this floor so EIP(src,dst)info is sent from this floor
//BufferedReader inFromUser =new BufferedReader(new InputStreamReader(System.in));
int eleLoc=4;

    byte addr[]=new byte[]{(byte)192,(byte)168,1,37};
    byte addr1[]=new byte[]{(byte)192,(byte)168,1,35};
try{flagCom ex=new flagCom(flag,c);}
catch(Exception e){}
 DatagramSocket clientSocket = new DatagramSocket();

InetAddress IPAddress = InetAddress.getByAddress(addr);
InetAddress IPAdd = InetAddress.getByAddress(addr1);

//System.out.println(IPAddress);
byte[] sendData = new byte[]{4,5};//EIP
byte[] sendData1 = new byte[]{4,3};//EIP

byte[] receiveData = new byte[1024];

DatagramPacket receivePkt =new DatagramPacket(receiveData, receiveData.length);
//String sentence=inFromUser.readLine();
/*sendData[0]=5;
sendData[1]=3;*/
DatagramPacket sendPacket =new DatagramPacket(sendData, sendData.length,IPAddress,9834);
clientSocket.send(sendPacket);
System.out.println("after sending1");

DatagramPacket sendPket =new DatagramPacket(sendData1, sendData1.length,IPAdd,1236);
clientSocket.send(sendPket);
System.out.println("after sending2");
//DatagramPacket receivePacket =new DatagramPacket(receiveData, receiveData.length);

//System.out.println("jsd");
byte packet[]=new byte[10];
//Thread t=new Thread("one");
int i=0;
while(i!=2)
{//while no of packets to receive is less no of below floors and above floors(only in case of middle floors)
    clientSocket.receive(receivePkt);
//String modifiedSentence = new String(receivePacket.getData());
packet=receivePkt.getData();
System.out.println("FROM SERVER :"+packet[0]+" "+packet[1]);
//eleLoc is the current floor id and packet[0] is the floorid from which density is recieved.
//clientSocket.receive(receivePkt);
System.out.println("received");
//packet=receivePkt.getData();
if(packet[0]<eleLoc)
    TBF+=packet[1];

else
    TAF+=packet[1];
i++;

System.out.println("TAF="+TAF+" TBF="+TBF);
}
clientSocket.close();
}
}