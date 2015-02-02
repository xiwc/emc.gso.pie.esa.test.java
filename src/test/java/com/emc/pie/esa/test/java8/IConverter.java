package com.emc.pie.esa.test.java8;

@FunctionalInterface
public interface IConverter<F, T>
{
	T convert(F from);

	public static void main(String[] args)
	{
		IConverter<String, Integer> converter = (from) -> Integer.valueOf(from);

		System.out.println(converter.convert("123"));

		converter = Integer::valueOf;

		System.out.println(converter.convert("1234"));

		final int num = 1;

		converter = (from) -> Integer.valueOf(from + num);

		System.out.println(converter.convert("1"));

	}
}
