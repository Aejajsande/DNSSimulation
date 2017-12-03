import java.io.*;
import java.net.*;

public class IntermediateDNSServerSocket {
	public static void main(String argv[]) throws Exception {
		String hostName;
		String ipAddress;

		ServerSocket welcomeSocket = new ServerSocket(6353);
		IntermediateDNSServer intermediateDNSServer = new IntermediateDNSServer();

		while (true) {

			Socket connectionSocket = welcomeSocket.accept();

			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

			hostName = inFromClient.readLine();
			System.out.println("HostName recieved from Intermediate client socket as" + hostName);

			ipAddress = intermediateDNSServer.resolveHostName(hostName) + '\n';
			System.out.println("Ip address received from Final DNS server as : " + ipAddress);

			outToClient.writeBytes(ipAddress);
			System.out.println("Ip address sent to Intermediate  client socket as : " + ipAddress);

		}

	}
}
