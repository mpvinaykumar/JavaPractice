package com.java7.features;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * https://howtodoinjava.com/java-7/automatic-resource-management-with-try-with-resources-in-java-7/
*/
public class ResourceManagementInJava7 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("C:/temp/test.txt"))) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/*
 * There are two things to closely watch: 1.File resource (BufferedReader) is
 * opened in try block in special manner (inside small brackets). 2.Finally
 * block is completely gone.
 */