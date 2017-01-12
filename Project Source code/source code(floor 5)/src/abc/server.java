/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abc;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/**
 *
 * @author sachcharit
 */
public class server {

    public server(byte[] b2,byte [] flag)throws Exception
{
    //Acting as both server and client
System.out.println("inside server");
    DatagramSocket serverSocket = new DatagramSocket(9834);
DatagramSocket flagSocket=new DatagramSocket(7054);
//DatagramSocket flag1Socket = new DatagramSocket();

byte[] receiveData = new byte[1024];
//byte[] flag1= new byte[10];
byte[] sendData = new byte[1024];
byte[] recv=new byte[1024];
//InetAddress IP=InetAddress.getByAddress(new byte[]{(byte)192,(byte)168,1,36});
//DatagramPacket sendpk=new DatagramPacket(sendData,sendData.length,IP,3456);
//flag1Socket.send(sendpk);
//DatagramPacket receivePk =new DatagramPacket(recv, recv.length);
/*System.out.println("flr 3");
flag1Socket.receive(receivePk);
System.out.println("aftr flr 3");
flag1=receivePk.getData();
for(int p=1;p<=5;p++)
System.out.println("flag1="+flag1[p]);*/
//flag2=flag1;
//System.out.println("flag2[4]"+flag2[4]);
//receving from flr4
DatagramPacket receivePack =new DatagramPacket(receiveData, receiveData.length);

flagSocket.receive(receivePack);
//System.out.println("after receiving");
InetAddress IPAddr=receivePack.getAddress();
int port1=receivePack.getPort();
//int x=1;
//while(x<3)
//{
sendData=flag;
//InetAddress IPAddr=InetAddress.getByAddress(new byte[]{(byte)192,(byte)168,1,37});
//System.out.println(IPAddr);
DatagramPacket sendPket =new DatagramPacket(sendData, sendData.length,IPAddr,port1);
//sending flag to flr5
flagSocket.send(sendPket);
//System.out.println("flag2[4]="+flag1[4]);

System.out.println("after sending first flag");//end of flag comm to flr5
//Thread t=new Thread();
//wait();
//System.out.println("flag2[4]="+flag1[4]);

//System.out.println("flag1[3]="+flag[3]);
//System.out.println("flag2[4]="+flag1[4]);

/*DatagramPacket sendflg =new DatagramPacket(flag1, flag1.length,IPAddr,port1);

try{
    Thread.sleep(1000);
}
catch(Exception e)
{}
//sendData=flag1;
flagSocket.send(sendflg);
System.out.println("after sending second flag");//end of flag comm to flr5
//x++;
//}

*/
//receving EIP from flr4

DatagramPacket receivePacket =new DatagramPacket(receiveData, receiveData.length);
System.out.println("before receive");
serverSocket.receive(receivePacket);
System.out.println("after");
byte b[] = new byte[10];
b=receivePacket.getData();//storing EIP packet frm flr4 
System.out.println("EIP="+b[0]+" "+b[1]);

InetAddress IPAddress = receivePacket.getAddress();
InetAddress IPAdd=InetAddress.getByAddress(new byte[]{(byte)192,(byte)168,1,36});
int port = receivePacket.getPort();
//String capitalizedSentence= sentence.toUpperCase();
//byte data[]=new byte[10]; 
//sendData = capitalizedSentence.getBytes();

DatagramPacket sendPacket =new DatagramPacket(b2, b2.length,IPAddress, port);
//sendData=flag;
//serverSocket.send(sendPacket);
//sendData=b2;
System.out.println(b2[0]+" "+b2[1]);
serverSocket.send(sendPacket);
/*if(b[1]!=5)
{
    sendData=b;
    DatagramPacket sendPkt =new DatagramPacket(sendData, sendData.length,IPAdd, 1236);
    serverSocket.send(sendPkt);
    serverSocket.receive(receivePacket);
    byte b1[]=new byte[10];
    b1=receivePacket.getData();
    System.out.println("FIP="+b1[0]+" "+b1[1]);
   // if(receiveData[1]!=4){
   // System.out.println("s");
    System.out.println(port);
        DatagramPacket sendPt =new DatagramPacket(b1, b1.length,IPAddress, port);
        serverSocket.send(sendPt);
        
  // }        
}*/
//}
flagSocket.close();
serverSocket.close();
}
}

