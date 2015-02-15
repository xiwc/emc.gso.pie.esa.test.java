package com.emc.pie.esa.test.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectorTest
{
	public static void main(String[] args)
	{
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("1", new ArrayList<String>());
		map.put("2", new ArrayList<String>());

		map.get("1").add("1");
		map.get("1").add("1");
		map.get("1").add("1");

		map.get("2").add("1");
		map.get("2").add("1");

		Integer collect = map.values().stream()
				.collect(Collectors.summingInt(List::size));

		System.out.println(collect);
	}

}
