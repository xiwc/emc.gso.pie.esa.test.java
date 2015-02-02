package com.emc.pie.esa.test.java8;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Person
{
	String firstName;
	String lastName;

	Person()
	{
	}

	public Person(String firstName, String lastName)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString()
	{
		return "Person [firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}

	public static void main(String[] args)
	{
		PersonFactory<Person> factory = Person::new;

		System.out.println(factory.create("Peter", "Parker"));

		Supplier<Person> supplier = Person::new;

		System.out.println(supplier.get());

		Consumer<Person> consumer = (p) -> System.out.println("Hello, "
				+ p.firstName);

		consumer.accept(new Person("Luke", "sky"));
	}

}

interface PersonFactory<P extends Person>
{
	P create(String f, String l);
}
