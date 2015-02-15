package com.emc.pie.esa.test.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaMapReduce
{
	private static List<User> users = Arrays.asList(new User(1, "张三", 12,
			User.Sex.MALE), new User(2, "李四", 21, User.Sex.FEMALE), new User(3,
			"王五", 32, User.Sex.MALE), new User(4, "赵六", 32, User.Sex.FEMALE));

	public static void main(String[] args)
	{
		double average = users.stream()
				.filter(p -> p.getGender() == User.Sex.MALE)
				.mapToInt(User::getAge).average().getAsDouble();

		List<Integer> nums = Arrays.asList(1, 2, 3, 4);
		List<Integer> squareNums = nums.stream().map(n -> n * n)
				.collect(Collectors.toList());

	}

}
