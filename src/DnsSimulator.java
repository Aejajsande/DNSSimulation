import java.io.*;
import java.net.*;

public class DnsSimulator {

	public static void main(String[] args) {
		String hostName = "";
		String ipAddress = "";
		try {

			System.out.println("Enter the web address");
			BufferedReader inputHostName = new BufferedReader(new InputStreamReader(System.in));
			hostName = inputHostName.readLine();
			System.out.println(hostName);

			SocketClient client = new SocketClient();
			client.resolveHostName(hostName);
			ipAddress = client.receiveIpFromServerSocket();
			System.out.println(ipAddress);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
