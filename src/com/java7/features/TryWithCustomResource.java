package com.java7.features;

/*
 * https://howtodoinjava.com/java-7/automatic-resource-management-with-try-with-resources-in-java-7/
*/
class CustomResource implements AutoCloseable {
	public void accessResource() {
		System.out.println("Accessing the resource");
	}

	@Override
	public void close() throws Exception {
		System.out.println("CustomResource closed automatically");
	}
}

public class TryWithCustomResource {
	public static void main(String[] args) {
		try (CustomResource cr = new CustomResource()) {
			cr.accessResource();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}