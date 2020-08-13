package com.study04Socket;

import java.io.IOException;
import java.net.InetAddress;

public class Test01Socket {

	public static void main(String[] args) throws IOException {

		InetAddress localHost = InetAddress.getLocalHost();
		System.out.println(localHost.getHostAddress());
		System.out.println(localHost.getHostName());
		System.out.println(localHost.getCanonicalHostName());
		System.out.println("==================");
		byte[] address = localHost.getAddress();
		for (byte b : address) {
			System.out.println(b);
		}

//		System.out.println(InetAddress.getAllByName());

//		try(Socket s = new Socket("time-a.nist.gov", 80);
//			Scanner in = new Scanner(s.getInputStream(),"UTF-8")){
//			while(in.hasNextLine()){
//				String line = in.nextLine();
//				System.out.println(line);
//			}
//		}
	}
}
