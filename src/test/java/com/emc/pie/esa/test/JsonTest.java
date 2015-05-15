package com.emc.pie.esa.test;

import java.util.Date;

import org.junit.Test;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonTest {

	// Gson gson = new
	// GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").excludeFieldsWithoutExposeAnnotation().create();
	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

	Gson gson2 = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

	@Test
	public void test01() {
		String json = gson.toJson(new User("tester", 20D, "男", new Date(), true));

		System.out.println(json);

		User user = gson.fromJson(json, User.class);

		System.out.println(user);

		System.out.println(gson2.toJson(user));
	}

}

class User {
	@Expose
	@SerializedName("userName")
	private String name;
	@Expose
	private double age;
	@Expose
	private String sex;
	@Expose
	private Date birthday;
	@Expose
	private boolean isLeader;

	public User(String name, double age, String sex, Date birthday, boolean isLeader) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
		this.isLeader = isLeader;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isLeader() {
		return isLeader;
	}

	public void setLeader(boolean isLeader) {
		this.isLeader = isLeader;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", sex=" + sex + ", birthday=" + birthday + ", isLeader="
				+ isLeader + "]";
	}


}
