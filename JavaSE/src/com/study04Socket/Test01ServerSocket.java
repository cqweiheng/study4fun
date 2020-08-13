package com.study04Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Test01ServerSocket {

	public static void main(String[] args) throws IOException {

		try(ServerSocket s = new ServerSocket(8189)){
			try(Socket inComing = s.accept()){
				InputStream inputStream = inComing.getInputStream();
				OutputStream outputStream = inComing.getOutputStream();
				try(Scanner in = new Scanner(inputStream, "UTF-8")){
					PrintWriter out
						= new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
					out.println("Hello~ Enter BYE to exit.");
					boolean done = false;
					while(!done && in.hasNextLine()){
						String line = in.nextLine();
						out.println("Echo:" + line);
						if(line.trim().equals("BYE")){
							done = true;
						}
					}
				}
			}
		}
	}
}
