package com.emc.pie.esa.test.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest
{
	public static void main(String[] args)
	{
		List<String> list = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(list, new Comparator<String>()
		{

			@Override
			public int compare(String o1, String o2)
			{

				return o2.compareTo(o1);
			}
		});

		Collections.sort(list, (String a, String b) ->
		{
			return b.compareTo(a);
		});

		Collections.sort(list, (String a, String b) -> b.compareTo(a));

		Collections.sort(list, (a, b) -> b.compareTo(a));
	}
}
