package com.sqlconn.test;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;

import com.pro.utils.MyRsa;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

public class RsaTest {

	public static void main(String[] args) throws Exception  {
	
	      
		    String input = "Today have a good news!ha!haha!=="; 
		    RSAPublicKey pubKey;
		    RSAPrivateKey privKey;
		    String pubkeystr;
		    String privkeystr;
		    String strenstr=null;
		    String strdestr=null;;
		          
			    MyRsa.generateKeyPair();
		        pubKey = (RSAPublicKey) MyRsa.getPublicKey(MyRsa.PUBLIC_KEY_PATH);
		        privKey = (RSAPrivateKey) MyRsa.getPrivateKey(MyRsa.PRIVATE_KEY_PATH);
		        pubkeystr=MyRsa.getPublicKeyEn64(pubKey);
		        privkeystr=MyRsa.getPrivateKeyEn64(privKey);
		        strenstr=MyRsa.encrypt(MyRsa.getPulbickeyDE64(pubkeystr), input);      
		        strdestr=MyRsa.decrypt(MyRsa.getPrivatekeyDe64(privkeystr), strenstr);

		        //加密后的东西 
		        System.out.println("编码后公钥：" + pubkeystr);     
		        System.out.println("编码后私钥: " + privkeystr);  
		        System.out.println("加密后: " + strenstr);  
		        System.out.println("解密后: " + strdestr); 
		        
	}
	}
	

