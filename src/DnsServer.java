import java.net.*;

public class DnsServer {
	IntermediateDNSClientSocket intSocketClient = new IntermediateDNSClientSocket();
	String ipAddressAtIntermediateServer;

	public String resolveHostName(String hostName) {
		String ipAddress = null;
		try {
			if (hostName.equals("localhost")) {
				ipAddress = InetAddress.getByName(hostName).toString();
				System.out.println("Ip Addreess is resolved as " + ipAddress);
			} else {
				intSocketClient.resolveHostName(hostName);
				ipAddress = intSocketClient.receiveIpFromServerSocket();
				System.out.println("hostName not resolved on local server and is sent to intermediate server");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ipAddress;
	}
}
