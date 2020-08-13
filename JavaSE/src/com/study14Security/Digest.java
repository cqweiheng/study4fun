package com.study14Security;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;

public class Digest {

	public static void main(String[] args) throws Exception {

		String algname = args.length >= 2 ? args[1] : "SHA-1";
		MessageDigest alg = MessageDigest.getInstance(algname);
		byte[] input = Files.readAllBytes(Paths.get(args[0]));
		byte[] hash = alg.digest(input);
		String d = "";
		for (int i = 0; i < hash.length; i++) {
			int v = hash[i] & 0xFF;
			if(v < 16) {
				d += "0";
			}
			d += Integer.toString(v,16).toUpperCase() + " ";
		}
		System.out.println(d);
	}
}
