package com.emc.pie.esa.test.java8;

import java.lang.annotation.Repeatable;

@Hint("1")
@Hint("2")
// @Hints({ @Hint("1"), @Hint("2") })
public class AnnotationTest
{

}

@interface Hints
{
	Hint[] value();
}

@Repeatable(Hints.class)
@interface Hint
{
	String value();
}
