package com.emc.pie.esa.test;

public class ExceptionTest
{
	public static void main(String[] args)
	{
		test();
	}

	static void test()
	{
		try
		{
			throw new RuntimeException("test exception...");
		}
		// catch (Exception e)
		// {
		// System.out.println(e.getMessage());
		// }
		finally
		{
			System.out.println("finally...");
		}
	}
}
