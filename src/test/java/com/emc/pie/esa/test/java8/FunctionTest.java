package com.emc.pie.esa.test.java8;

import java.util.function.Function;

public class FunctionTest
{
	public static void main(String[] args)
	{
		Function<String, Integer> toInt = Integer::valueOf;
		Function<String, String> toStr = toInt.andThen(String::valueOf);

		System.out.println(toStr.apply("123"));
	}
}
