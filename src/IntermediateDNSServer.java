import java.net.*;

public class IntermediateDNSServer {
	FinalDNSClientSocket intSocketClient = new FinalDNSClientSocket();
	String ipAddressAtIntermediateServer;

	public String resolveHostName(String hostName) {
		String ipAddress = null;
		try {

			intSocketClient.resolveHostName(hostName);
			ipAddress = intSocketClient.receiveIpFromServerSocket();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ipAddress;
	}
}
