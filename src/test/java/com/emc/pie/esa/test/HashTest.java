package com.emc.pie.esa.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.testng.annotations.Test;

public class HashTest
{
	@Test
	public void test()
	{
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append("/api/types/disk/instances/?filter=id eq \"dpe_disk_10\"");

		int reflectionHashCode = builder.reflectionHashCode(new Object());

		System.out.println(reflectionHashCode);

		byte[] sha1 = DigestUtils
				.sha1("/api/types/disk/instances/?filter=id eq \"dpe_disk_10\"");

		for (byte b : sha1)
		{
			System.out.print(b);
		}

		System.out.println();
	}
}
