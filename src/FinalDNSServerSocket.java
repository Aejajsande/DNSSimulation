import java.io.*;
import java.net.*;

public class FinalDNSServerSocket {
	public static void main(String argv[]) throws Exception {
		String hostName;
		String ipAddress;

		ServerSocket welcomeSocket = new ServerSocket(6459);
		FinalDNSServer dnsServer = new FinalDNSServer();

		while (true) {

			Socket connectionSocket = welcomeSocket.accept();

			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

			hostName = inFromClient.readLine();
			System.out.println("HostName recieved from Final client socket as" + hostName);

			ipAddress = dnsServer.resolveHostName(hostName).toString() + '\n';
			System.out.println("Ip address recieved from Final dns server as :" + ipAddress);
			outToClient.writeBytes(ipAddress);
			System.out.println("Ip address sent to client socket as : " + ipAddress);

		}

	}
}
