import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
class P2{
	public static void main(String[] args) throws Exception{
		DatagramSocket forwarder = new DatagramSocket(1234);
		DatagramPacket packet = null;
		InetAddress ip  = InetAddress.getLocalHost();
		byte[] receive_packet = new byte[65536];
		byte[] send_packet = new byte[65536];
		String message="";
		while(!message.equalsIgnoreCase("bye")){
			packet = new DatagramPacket(receive_packet,receive_packet.length);
			forwarder.receive(packet);
			message=convertToString(receive_packet);
			if(message.equalsIgnoreCase("bye")){
				System.out.print("Connection ended!");
				break;
			}
			System.out.print("\nClient:"+message);
			if((Integer.parseInt(message)) < 1000){
				int number =Integer.parseInt(message); 
				message =(number*number)+"";
				send_packet=message.getBytes();
				packet = new DatagramPacket(send_packet,send_packet.length,ip,2222);
				forwarder.send(packet);
			}
			else
			{
				System.out.print("\nWarning:Number greater than 1000!");
			}
			receive_packet = new byte[65536];
			send_packet = new byte[65536];
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