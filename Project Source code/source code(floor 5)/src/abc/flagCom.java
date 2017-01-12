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
    System.out.println("inside flagcom");
    DatagramSocket flagSocket = new DatagramSocket();
    byte addr[]=new byte[]{(byte)192,(byte)168,1,36};
    byte[] f=new byte[6];
byte[] fcurr=new byte[10];
byte[] receiveData=new byte[1024];
InetAddress IPAddress = InetAddress.getByAddress(addr);
byte[] sendstring=new byte[10];
sendstring[0]=5;
fcurr=flag;
//sending mechanism b/w 5 and 4.
DatagramPacket sendFlag=new DatagramPacket(sendstring,sendstring.length,IPAddress,7654);
flagSocket.send(sendFlag);//end of sending mechanism.
System.out.println("after send");
int j=0;
int sum=0;
for(int p=1;p<=5;p++){
    sum+=c[p];
}
DatagramPacket receivePacket =new DatagramPacket(receiveData, receiveData.length);
while(j!=2){
   System.out.println("before receive");
    flagSocket.receive(receivePacket);
    System.out.println("after");
    f=receivePacket.getData();
for(int p=1;p<=5;p++)
{
System.out.print("f="+f[p]+" ");
}
System.out.println();
for(int k=1;k<=4;k++){
    //if(sum<10){
    if(fcurr[k]==0){
    if(f[k]==1)
        fcurr[k]=1;
    }
    //}
    //else
      //  break;
    }
    for(int p=1;p<=5;p++)
{
System.out.print("fcurr="+fcurr[p]+" ");}
j++;
}
for(int i=1;i<=5;i++)
  System.out.println("flag="+flag[i]); 
}   
}
