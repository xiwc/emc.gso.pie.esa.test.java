package com.emc.pie.esa.test;

import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(threadPoolSize = 3, invocationCount = 10, timeOut = 10000)
public class TestNGTest {

	@Test(dependsOnMethods = { "trim" }, enabled = false)
	public void isEmpty() {
		assert StringUtils.isEmpty(null);
		assert StringUtils.isEmpty("");
	}

	@Test(dependsOnGroups = { "g1.*" }, enabled = true)
	public void trim() {
		assert "foo".equals(StringUtils.trim("  foo   "));
	}

	@Test(dataProvider = "data", groups = { "g1" })
	public void verifyData1(String p1, String p2) {
		System.out.println(StringUtils.join(new Object[] { p1, p2 }, " "));
	}

	@Test(dataProvider = "data", groups = { "g1" })
	public void verifyData2(String p1, String p2) {
		System.out.println(StringUtils.join(new Object[] { p1, p2 }, " "));
	}

	@DataProvider(name = "data")
	public Object[][] data(Method m) {
		System.out.println(m.getName());
		return new Object[][] { { "t1", "t1" }, { "t2", "t2" } };
	}
}
