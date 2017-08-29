package com.sqlconn.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.pro.utils.MyMd5;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class Md5Test {
	private static MessageDigest instance;
	private static byte[] digest;
	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		String str="this is test ";
		
		instance = MessageDigest.getInstance("MD5");
		instance.update(str.getBytes());
		digest = instance.digest();

		String stren64=Base64.encode(digest);
		byte[] strde64=Base64.decode(stren64);
		
		System.out.println(str);
		System.out.println(stren64);
		System.out.println(MyMd5.byteArrayToHex(strde64));
        System.out.println(MyMd5.byteArrayToHex(digest));
        System.out.println(MyMd5.getMd5(str));
	}
}
