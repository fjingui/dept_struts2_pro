package com.pro.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyMd5 {

	private static MessageDigest instance;
	private static byte[] digest;

	public static String byteArrayToHex(byte[] byteArray) {
		
	  char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'a','b','c','d','e','f' };
	  char[] resultCharArray =new char[byteArray.length * 2];
	  int index = 0;

	  for (byte b : byteArray) {

	     resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];

	     resultCharArray[index++] = hexDigits[b& 0xf];

	  }

	  return new String(resultCharArray);
	}
	
    public static String getMd5(String plainText) {  
        try {  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            md.update(plainText.getBytes());  
            byte b[] = md.digest();  
  
            int i;  
  
            StringBuffer buf = new StringBuffer("");  
            for (int offset = 0; offset < b.length; offset++) {  
                i = b[offset];  
           
                if (i < 0)  
                    i += 256;  
                if (i < 16)  
                    buf.append("0");  
                buf.append(Integer.toHexString(i));  
            }  
            return buf.toString();  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
            return null;  
        }  
  
    }  
}
