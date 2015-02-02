package com.emc.pie.esa.test;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CommonTest {
	@Test(dataProvider = "dp")
	public void f(Integer n, String s) {
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

	@Test
	public void test01() {

		Object obj = 0;
		Integer i = 0;
		Boolean b = true;
		System.out.println(obj.getClass().isPrimitive());
		System.out.println(i.getClass().isPrimitive());
		System.out.println(i.getClass().getName());
		System.out.println(i.getClass().getSimpleName());
		System.out.println(java.lang.Boolean.TYPE.isPrimitive());
	}

	@Test
	public void test02()
	{
		System.out.println(HttpMethod.GET.name());
		System.out.println(HttpMethod.GET.toString());
	}

	public static enum HttpMethod
	{
		GET, POST, PUT, DELETE

	}

	@Test
	public void test03()
	{
		List<String> list = Arrays.asList(new String[0]);

		System.out.println(list.size());

		Assert.assertEquals(list.size(), 0);

		try
		{
			Arrays.asList(new String[1]).add("test");
		}
		catch (Exception e)
		{
			// e.printStackTrace();
			Assert.assertTrue(e instanceof UnsupportedOperationException);
		}
	}

	@Test
	public void test04()
	{
		ToStringBuilder builder = new ToStringBuilder(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
		builder.append("name", "test name");
		builder.append("age", 10);

		ToStringBuilder builder2 = new ToStringBuilder(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
		builder2.append("name2", "test name");
		builder2.append("age2", 10);

		builder.appendToString(builder2.toString());

		System.out.println(builder.toString());
	}

}
