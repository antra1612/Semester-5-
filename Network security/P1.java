import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Scanner;
class P1{
	public static void main(String[] args) throws Exception{
		DatagramSocket sender = new DatagramSocket();
		DatagramPacket packet = null;
		InetAddress ip  = InetAddress.getLocalHost();
		byte[] send_packet = new byte[65536];
		Scanner in = new Scanner(System.in);
		String message="";
		while(!message.equalsIgnoreCase("bye")){
			System.out.print("Enter number:");
			message=in.nextLine();
			if(message.equalsIgnoreCase("bye")){
				System.out.print("Connection ended!");
				break;
			}
			send_packet=message.getBytes();
			packet = new DatagramPacket(send_packet,send_packet.length,ip,1234);
			sender.send(packet);
			send_packet=new byte[65536];
		}
	}
}