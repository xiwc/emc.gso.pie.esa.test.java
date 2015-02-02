package com.emc.pie.esa.test.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class StreamTest
{
	public static void main(String[] args)
	{
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");

		stringCollection.stream().filter((s) -> s.startsWith("a"))
				.forEach(System.out::println);

		stringCollection.stream().sorted().filter((s) -> s.startsWith("a"))
				.forEach(System.out::println);

		stringCollection.stream().map(String::toUpperCase)
				.sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);

		boolean anyStartsWithA = stringCollection.stream().anyMatch(
				(s) -> s.startsWith("a"));
		System.out.println(anyStartsWithA); // true
		boolean allStartsWithA = stringCollection.stream().allMatch(
				(s) -> s.startsWith("a"));
		System.out.println(allStartsWithA); // false
		boolean noneStartsWithZ = stringCollection.stream().noneMatch(
				(s) -> s.startsWith("z"));
		System.out.println(noneStartsWithZ); // true

		long startsWithB = stringCollection.stream()
				.filter((s) -> s.startsWith("b")).count();
		System.out.println(startsWithB); // 3

		Optional<String> reduced = stringCollection.stream().sorted()
				.reduce((s1, s2) -> s1 + "#" + s2);
		reduced.ifPresent(System.out::println);
		// "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"

		int max = 1000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++)
		{
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}

		// long t0 = System.nanoTime();
		// long count = values.stream().sorted().count();
		// System.out.println(count);
		// long t1 = System.nanoTime();
		// long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		// System.out
		// .println(String.format("sequential sort took: %d ms", millis));

		// long t0 = System.nanoTime();
		// long count = values.parallelStream().sorted().count();
		// System.out.println(count);
		// long t1 = System.nanoTime();
		// long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		// System.out.println(String.format("parallel sort took: %d ms",
		// millis));

		Map<Integer, String> map = new HashMap<>();
		for (int i = 0; i < 10; i++)
		{
			map.putIfAbsent(i, "val" + i);
		}

		map.forEach((id, val) -> System.out.println(val));

		map.computeIfPresent(3, (num, val) -> val + num);
		map.get(3); // val33
		map.computeIfPresent(9, (num, val) -> null);
		map.containsKey(9); // false
		map.computeIfAbsent(23, num -> "val" + num);
		map.containsKey(23); // true
		map.computeIfAbsent(3, num -> "bam");
		map.get(3); // val33
	}
}
