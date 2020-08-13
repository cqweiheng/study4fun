package com.study14Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;

public class EncryptTest {

	public static void main(String[] args) throws Exception {

		KeyGenerator aes = KeyGenerator.getInstance("AES");
		SecureRandom random = new SecureRandom();
		random.setSeed(200);
		aes.init(random);
		SecretKey key = aes.generateKey();
		System.out.println(key);

	}

	public void encrypt() throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");

	}
}
