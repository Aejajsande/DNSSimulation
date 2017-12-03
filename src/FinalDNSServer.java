import java.net.*;

public class FinalDNSServer {

	public String resolveHostName(String hostName) {
		String ipAddress = null;
		try {

			ipAddress = InetAddress.getByName(hostName).toString();
			System.out.println("Ip Addreess is resolved as " + ipAddress);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ipAddress;
	}
}
