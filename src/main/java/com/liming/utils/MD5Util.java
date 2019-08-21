package com.liming.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Copyright: Copyright (c) 2019 liming
 * 
 * @Description: 该类的功能描述
 * @author: ALPHA.GJ.
 * @date: 2019年7月4日 上午10:53:53
 */
public class MD5Util {
	public static final String md5(String password, String salt) {
		// 加密方式
		String hashAlgorithmName = "MD5";
		// 盐：为了即使相同的密码不同的盐加密后的结果也不同
		ByteSource byteSalt = ByteSource.Util.bytes(salt);
		// 密码
		Object source = password;
		// 加密次数
		int hashIterations = 2;
		SimpleHash result = new SimpleHash(hashAlgorithmName, source, byteSalt, hashIterations);
		return result.toString();
	}

	public static void main(String[] args) {
		String str = md5("123", "wx");
		System.out.print(str);
	}
}
