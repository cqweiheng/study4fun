package com.study02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Test03ZipStream {

	public static void main(String[] args) throws IOException {
		ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("C:\\Users\\Thinkpad\\Desktop\\test2.rar"));
	}

	public static void writeZipFile() throws IOException {

		FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Thinkpad\\Desktop\\Desktop.rar");
		ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
		ZipEntry zip1 = new ZipEntry("zip1");

	}
}
