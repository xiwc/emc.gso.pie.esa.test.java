package com.emc.pie.esa.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class LogTest
{
	Logger log = LoggerFactory.getLogger(LogTest.class);

	@Test
	public void test()
	{
		log.debug("test {}, test {}.", "p1", "p2");
		log.debug("test {}, test {}.", new String[] { "p1", "p2" });
	}
}
