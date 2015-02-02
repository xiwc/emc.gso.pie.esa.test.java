package com.emc.pie.esa.test.java8;

public interface IFormula
{
	double calculate(int a);

	default double sqrt(int a)
	{
		return Math.sqrt(a);
	}

	public static void main(String[] args)
	{
		System.out.println("test");

		IFormula formula = new IFormula()
		{

			@Override
			public double calculate(int a)
			{
				return sqrt(a * 100);
			}
		};

		System.out.println(formula.calculate(100));
		System.out.println(formula.sqrt(16));
	}
}
