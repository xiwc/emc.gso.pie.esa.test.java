package com.emc.pie.esa.test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

	public static void main(String[] args) throws URISyntaxException {

		URL resource = Main.class.getResource("test.txt");

		System.out.println(resource.toString());

		File file = new File(resource.toURI());

		System.out.println(file.getAbsoluteFile());

	}

}
