package com.emc.pie.esa.test.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class StreamTest
{
	public static void main(String[] args)
	{
		// List<String> stringCollection = new ArrayList<>();
		// stringCollection.add("ddd2");
		// stringCollection.add("aaa2");
		// stringCollection.add("bbb1");
		// stringCollection.add("aaa1");
		// stringCollection.add("bbb3");
		// stringCollection.add("ccc");
		// stringCollection.add("bbb2");
		// stringCollection.add("ddd1");
		//
		// stringCollection.stream().filter((s) -> s.startsWith("a"))
		// .forEach(System.out::println);
		//
		// stringCollection.stream().sorted().filter((s) -> s.startsWith("a"))
		// .forEach(System.out::println);
		//
		// stringCollection.stream().map(String::toUpperCase)
		// .sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);
		//
		// boolean anyStartsWithA = stringCollection.stream().anyMatch(
		// (s) -> s.startsWith("a"));
		// System.out.println(anyStartsWithA); // true
		// boolean allStartsWithA = stringCollection.stream().allMatch(
		// (s) -> s.startsWith("a"));
		// System.out.println(allStartsWithA); // false
		// boolean noneStartsWithZ = stringCollection.stream().noneMatch(
		// (s) -> s.startsWith("z"));
		// System.out.println(noneStartsWithZ); // true
		//
		// long startsWithB = stringCollection.stream()
		// .filter((s) -> s.startsWith("b")).count();
		// System.out.println(startsWithB); // 3
		//
		// Optional<String> reduced = stringCollection.stream().sorted()
		// .reduce((s1, s2) -> s1 + "#" + s2);
		// reduced.ifPresent(System.out::println);
		// // "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"
		//
		// int max = 1000000;
		// List<String> values = new ArrayList<>(max);
		// for (int i = 0; i < max; i++)
		// {
		// UUID uuid = UUID.randomUUID();
		// values.add(uuid.toString());
		// }

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

		// Map<Integer, String> map = new HashMap<>();
		// for (int i = 0; i < 10; i++)
		// {
		// map.putIfAbsent(i, "val" + i);
		// }
		//
		// map.forEach((id, val) -> System.out.println(val));
		//
		// map.computeIfPresent(3, (num, val) -> val + num);
		// map.get(3); // val33
		// map.computeIfPresent(9, (num, val) -> null);
		// map.containsKey(9); // false
		// map.computeIfAbsent(23, num -> "val" + num);
		// map.containsKey(23); // true
		// map.computeIfAbsent(3, num -> "bam");
		// map.get(3); // val33

		List<String> list = Arrays.asList("11", "22", "33");

		long count = list.stream().flatMap((String s) ->
		{
			Consumer<String> sink = (item) -> System.out.println(item);
			sink.accept(s);
			return Arrays.asList("1", "2", "3").stream();
		}).count();

		System.out.println(count);

		Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
				.peek(e -> System.out.println(e)).map(String::toUpperCase)
				.peek(e -> System.out.println(e)).collect(Collectors.toList());

		Stream.of("1,2,3", "4,5,6", "7,8,9")
				.flatMap(
						s -> Stream.of(s.split(",")).map(
								s1 -> Integer.valueOf(s1)))
				.peek(s -> System.out.println(s)).count();

		Assert.assertTrue(Stream.of("1,2,3", "4,5,6", "7,8,9").allMatch(
				s -> s.split(",").length == 3));

		String sss = null;
		String ss = Stream.of("11", "22", "33").reduce(sss, (a, b) ->
		{
			System.out.println(String.format("%s-%s", a, b));
			return a + b;
		});

		System.out.println(sss);
		System.out.println(ss);
	}
}
