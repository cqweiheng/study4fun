package com.study03ClassLoader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test02Crypt extends ClassLoader {

	public static void main(String[] args) throws Exception {
//		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		// class加密
//		String inFile = "D:\\Users\\IdeaProjects\\JavaSE\\out\\production\\JavaSE\\com\\study3ClassLoader\\bean\\Person.class";
		String outFile = "D:\\Users\\IdeaProjects\\JavaSE\\out\\production\\JavaSE\\com\\study3ClassLoader\\bean\\Person.crypt";
//		crypt(inFile, outFile, 3);
		// class解密
		String dFile = "com.study3ClassLoader.bean.Person";

		CryptoClassLoader cryptoClassLoader = new Test02Crypt().new CryptoClassLoader(3);
		Class<?> aClass = cryptoClassLoader.loadClass(outFile);
		System.out.println(aClass.newInstance());
	}

	public static void crypt(String inFile, String outFile, int cryptKey) throws IOException {
		try(FileInputStream inputStream = new FileInputStream(inFile);
			OutputStream outputStream = Files.newOutputStream(Paths.get(outFile))){
			int ch;
			while((ch = inputStream.read()) != -1){
				byte c = (byte)(ch + cryptKey);
				outputStream.write(c);
			}
		};
	}

	class CryptoClassLoader extends ClassLoader {

		private int key;

		public CryptoClassLoader(int key) {
			this.key = key;
		}

		@Override
		protected Class<?> findClass(String name) throws ClassNotFoundException {
			try{
				byte[] classBytes = loadClassBytes(name);
				Class<?> cl = defineClass(name, classBytes, 0, classBytes.length);
				if(cl == null){
					throw new ClassNotFoundException(name);
				}
				return cl;
			} catch (IOException e) {
				throw new ClassNotFoundException(name);
			}
		}

		private byte[] loadClassBytes(String name) throws IOException {
			String cname = name.replace(".", "/") + ".crypt";
			byte[] bytes = Files.readAllBytes(Paths.get(cname));
			for (int i = 0; i < bytes.length; i++) {
				bytes[i] = (byte)(bytes[i] - key);
			}
			return bytes;
		}
	}

}
