package com.emc.pie.esa.test.java8;

public class User
{
	int id;
	String name;
	int age;
	Sex gender;

	public User(int id, String name, int age, Sex gender)
	{
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public Sex getGender()
	{
		return gender;
	}

	public void setGender(Sex gender)
	{
		this.gender = gender;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public static enum Sex
	{
		MALE, FEMALE
	}

}
