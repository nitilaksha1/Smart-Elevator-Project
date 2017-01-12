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
 * @author ThinkPad
 */
public class flagCom {
public flagCom(byte[] flag,byte[] c)throws Exception{
    DatagramSocket flagSocket = new DatagramSocket();
    DatagramSocket flgSocket=new DatagramSocket();
    byte addr[]=new byte[]{(byte)192,(byte)168,1,37};
    byte addr1[]=new byte[]{(byte)192,(byte)168,1,35};
    byte[] f=new byte[10];
byte[] fcurr=new byte[10];
byte[] receiveData=new byte[1024];
InetAddress IPAddress = InetAddress.getByAddress(addr);
InetAddress IP=InetAddress.getByAddress(addr1);
byte[] sendstring=new byte[10];
fcurr=flag;
//sending mechanism b/w 5 and 4.
DatagramPacket sendFlag=new DatagramPacket(sendstring,sendstring.length,IPAddress,7054);
flagSocket.send(sendFlag);//end of sending mechanism.
System.out.println("after send1");

DatagramPacket sendflg2=new DatagramPacket(sendstring,sendstring.length,IP,3456);
flgSocket.send(sendflg2);
System.out.println("after send2flag");
int j=0;
DatagramPacket receivePacket1 =new DatagramPacket(receiveData, receiveData.length);
DatagramPacket receivePacket2 =new DatagramPacket(receiveData, receiveData.length);
flagSocket.receive(receivePacket2);
System.out.println("received frm 5");
f=receivePacket2.getData();
for(int i=1;i<=5;i++)
    System.out.println("f="+f[i]);
for(int x=1;x<=5;x++)
{
    if(fcurr[x]==0){
        if(f[x]==1)
            fcurr[x]=1;
    }
}
while(j!=1){
    System.out.println("before receive");
    Thread.sleep(1000);
    flgSocket.receive(receivePacket1);
    System.out.println("after");
    f=receivePacket1.getData();
for(int p=1;p<=5;p++)
{
System.out.print("f="+f[p]+" ");
}
int sum=0;
for(int i=0;i<=5;i++)
    sum+=c[i];
System.out.println();
for(int k=1;k<=4;k++){
    if(sum<=10)
    if(fcurr[k]==0){
    if(f[k]==1)
        fcurr[k]=1;
    }
    }
    for(int p=1;p<5;p++)
{
System.out.print("fcurr="+fcurr[p]+" ");
}
j++;
}
flagSocket.close();
flgSocket.close();
 }   
}
