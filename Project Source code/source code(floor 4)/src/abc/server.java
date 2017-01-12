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
DatagramSocket serverSocket = new DatagramSocket(1234);
DatagramSocket flagSocket=new DatagramSocket(7654);
DatagramSocket flag1Socket = new DatagramSocket();

byte[] receiveData = new byte[1024];
byte[] flag1= new byte[10];
byte[] sendData = new byte[1024];
byte[] recv=new byte[1024];
DatagramPacket receivePack =new DatagramPacket(receiveData, receiveData.length);
flagSocket.receive(receivePack);//reciving flag requesting floor id
byte x[]=new byte[3];
x=receivePack.getData();
if(x[0]==5)//checking floor id
{
InetAddress IP=InetAddress.getByAddress(new byte[]{(byte)192,(byte)168,1,35});
DatagramPacket sendpk=new DatagramPacket(sendData,sendData.length,IP,3456);
flag1Socket.send(sendpk);//sending flag request to 3rd flr
DatagramPacket receivePk =new DatagramPacket(recv, recv.length);
//System.out.println("flr 3");
flag1Socket.receive(receivePk);//receiving flag frm flr 3
//System.out.println("aftr flr 3");
flag1=receivePk.getData();
for(int p=1;p<=5;p++)
System.out.println("flag1="+flag1[p]);
//receving from flr5

InetAddress IPAddr=receivePack.getAddress();//flr 5
int port1=receivePack.getPort();
//int x=1;
//while(x<3)
//{
sendData=flag;
//InetAddress IPAddr=InetAddress.getByAddress(new byte[]{(byte)192,(byte)168,1,37});
//System.out.println(IPAddr);
DatagramPacket sendPket =new DatagramPacket(sendData, sendData.length,IPAddr,port1);
//sending flag to flr5
flagSocket.send(sendPket);//sending 1st flag to 5th flr

System.out.println("after sending first flag");//end of flag comm to flr5

DatagramPacket sendflg =new DatagramPacket(flag1, flag1.length,IPAddr,port1);

try{
    Thread.sleep(1000);
}
catch(Exception e)
{}
flagSocket.send(sendflg);//sending 2nd flag to flr 5
System.out.println("after sending second flag");//end of flag comm to flr5

//receving EIP from flr5

DatagramPacket receivePacket =new DatagramPacket(receiveData, receiveData.length);
serverSocket.receive(receivePacket);//receiving Eip frm flr5
byte b[] = new byte[10];
b=receivePacket.getData();//storing EIP packet frm flr5 
System.out.println("EIP="+b[0]+" "+b[1]);

InetAddress IPAddress = receivePacket.getAddress();//flr 5
InetAddress IPAdd=InetAddress.getByAddress(new byte[]{(byte)192,(byte)168,1,35});//flr 3
int port = receivePacket.getPort();

DatagramPacket sendPacket =new DatagramPacket(b2, b2.length,IPAddress, port);

System.out.println(b2[0]+" "+b2[1]);
serverSocket.send(sendPacket);//sending fip to flr 5
if(b[1]!=4)
{
    sendData=b;
    DatagramPacket sendPkt =new DatagramPacket(sendData, sendData.length,IPAdd, 1236);
    serverSocket.send(sendPkt);//sending Eip to 3rd flr
    serverSocket.receive(receivePacket);//receiving Fip frm 3
    byte b1[]=new byte[10];
    b1=receivePacket.getData();
    System.out.println("FIP="+b1[0]+" "+b1[1]);
        DatagramPacket sendPt =new DatagramPacket(b1, b1.length,IPAddress, port);
        serverSocket.send(sendPt); //sending fip of 3rd to 5th       
}
//}
flagSocket.close();
flag1Socket.close();
serverSocket.close();
}
else if(x[0]==3)
{
    InetAddress IP=InetAddress.getByAddress(new byte[]{(byte)192,(byte)168,1,37});//flr 5
DatagramPacket sendpk=new DatagramPacket(sendData,sendData.length,IP,7054);
flag1Socket.send(sendpk);//sending flag request to 5
DatagramPacket receivePk =new DatagramPacket(recv, recv.length);
//System.out.println("flr 3");
flag1Socket.receive(receivePk);//receiving flag from 5
//System.out.println("aftr flr 3");
flag1=receivePk.getData();
for(int p=1;p<=5;p++)
System.out.println("flag1="+flag1[p]);
//receving from flr5

InetAddress IPAddr=receivePack.getAddress();//flr 3
int port1=receivePack.getPort();
sendData=flag;
//InetAddress IPAddr=InetAddress.getByAddress(new byte[]{(byte)192,(byte)168,1,37});
//System.out.println(IPAddr);
DatagramPacket sendPket =new DatagramPacket(sendData, sendData.length,IPAddr,port1);
//sending flag to flr3
flagSocket.send(sendPket);

System.out.println("after sending first flag");//end of flag comm to flr5

DatagramPacket sendflg =new DatagramPacket(flag1, flag1.length,IPAddr,port1);

try{
    Thread.sleep(1000);
}
catch(Exception e)
{}
flagSocket.send(sendflg);
System.out.println("after sending second flag");//end of flag comm to flr5
//receving EIP from flr3

DatagramPacket receivePacket =new DatagramPacket(receiveData, receiveData.length);
serverSocket.receive(receivePacket);
byte b[] = new byte[10];
b=receivePacket.getData();//storing EIP packet frm flr3 
System.out.println("EIP="+b[0]+" "+b[1]);

InetAddress IPAddress = receivePacket.getAddress();//flr3
InetAddress IPAdd=InetAddress.getByAddress(new byte[]{(byte)192,(byte)168,1,37});//flr5
int port = receivePacket.getPort();

DatagramPacket sendPacket =new DatagramPacket(b2, b2.length,IPAddress, port);

System.out.println(b2[0]+" "+b2[1]);
serverSocket.send(sendPacket);//fip to flr 3
if(b[1]!=4)
{
    sendData=b;
    DatagramPacket sendPkt =new DatagramPacket(sendData, sendData.length,IPAdd,9834);
    serverSocket.send(sendPkt);//eip to flr 5
    serverSocket.receive(receivePacket);
    byte b1[]=new byte[10];
    b1=receivePacket.getData();
    System.out.println("FIP="+b1[0]+" "+b1[1]);
        DatagramPacket sendPt =new DatagramPacket(b1, b1.length,IPAddress, port);
        serverSocket.send(sendPt);        
}
//}
flagSocket.close();
flag1Socket.close();
serverSocket.close();

}
}
}


