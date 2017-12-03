import java.io.*;
import java.net.*;

class SocketClient {
	Socket clientSocket;
	String ipAddress;
	int port = 6789;

	public void resolveHostName(String hostName) throws Exception {
		clientSocket = new Socket("localhost", port);

		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		outToServer.writeBytes(hostName + '\n');
		System.out.println("host name sent to server socket as :" + hostName);
	}

	public String receiveIpFromServerSocket() throws Exception {
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		ipAddress = inFromServer.readLine();
		clientSocket.close();
		System.out.println("Ip address recieved from server socket as " + ipAddress);
		return ipAddress;
	}

}
