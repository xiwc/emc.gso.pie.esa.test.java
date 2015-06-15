package com.emc.pie.esa.test;

public class EnumTest {

	public static void main(String[] args) {

		Status sts = Status.valueOf("Open");

		System.out.println(sts);

		for (Status status : Status.values()) {
			System.out.println(status.name());
			System.out.println(status.toString());
		}
	}

}

enum Status {

	Open("打开"), Closed("关闭"), Deleted("删除");

	private String name;

	private Status(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}