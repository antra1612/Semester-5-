import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Scanner;
class P3{
	public static void main(String[] args) throws Exception{
		DatagramSocket server = new DatagramSocket(2222);
		DatagramPacket packet = null;
		InetAddress ip  = InetAddress.getLocalHost();
		byte[] receive_packet = new byte[65536];
		String message="";
		while(!message.equalsIgnoreCase("bye")){
			packet = new DatagramPacket(receive_packet,receive_packet.length);
			server.receive(packet);
			message=convertToString(receive_packet);
			if(message.equalsIgnoreCase("bye")){
				System.out.print("Connection ended!");
				break;
			}
			System.out.print("\nClient:"+message);
			receive_packet = new byte[65536];
		}
	}
	public static String convertToString(byte[] a){
		if(a == null)
			return null;
		String s = "";
			int i=0;
			while(a[i] != 0){
				s=s+(char)a[i];
				i++;
			}
		return s;
	}
}