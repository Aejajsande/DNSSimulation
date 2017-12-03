import java.io.*;
import java.net.*;

class SocketServer {

	public static void main(String argv[]) throws Exception {
		String hostName;
		String ipAddress;

		ServerSocket welcomeSocket = new ServerSocket(6789);
		DnsServer dnsServer = new DnsServer();

		while (true) {

			Socket connectionSocket = welcomeSocket.accept();

			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

			hostName = inFromClient.readLine();
			System.out.println("HostName recieved from client socket as" + hostName);

			ipAddress = dnsServer.resolveHostName(hostName) + '\n';

			outToClient.writeBytes(ipAddress);
			System.out.println("Ip address sent to client socket as : " + ipAddress);

		}
	}

}
