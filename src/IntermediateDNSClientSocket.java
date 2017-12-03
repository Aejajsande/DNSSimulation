import java.io.*;
import java.net.*;

public class IntermediateDNSClientSocket {
	Socket clientSocket;
	String ipAddress;
	int port = 6353;

	public void resolveHostName(String hostName) throws Exception {
		clientSocket = new Socket("localhost", port);

		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		outToServer.writeBytes(hostName + '\n');
		System.out.println("host name sent to Intermediate server socket as :" + hostName);
	}

	public String receiveIpFromServerSocket() throws Exception {
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		ipAddress = inFromServer.readLine();
		clientSocket.close();
		System.out.println("Ip address recieved from  Intermediate server socket as " + ipAddress);
		return ipAddress;
	}
}
