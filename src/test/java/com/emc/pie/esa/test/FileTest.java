package com.emc.pie.esa.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

public class FileTest
{
	@Test
	public void test() throws IOException
	{
		FileUtils.forceMkdir(new File("C:/temp/test"));
	}
}
