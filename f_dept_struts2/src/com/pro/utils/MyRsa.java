package com.pro.utils;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public class MyRsa {

    /** 指定加密算法为RSA */
    private static String ALGORITHM = "RSA";
    /*指定加密模式和填充方式*/
    private static String ALGORITHM_MODEL = "RSA/ECB/PKCS1Padding";
    /** 指定key的大小，一般为1024，越大安全性越高 */
    private static int KEYSIZE = 1024;
    /** 指定公钥存放文件 */
	public static final String PUBLIC_KEY_PATH="E:\\应用开发\\java web\\rsapublickey.txt";
	 /** 指定私钥存放文件 */
	public static final String PRIVATE_KEY_PATH="E:\\应用开发\\java web\\rsaprivatekey.txt";
	
    public static void generateKeyPair() throws NoSuchAlgorithmException, IOException{
    
        	KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
            SecureRandom secureRandom = new SecureRandom(new Date().toString().getBytes()); 
            keyPairGenerator.initialize(KEYSIZE, secureRandom); 
            KeyPair keyPair = keyPairGenerator.genKeyPair(); 
            byte[] publicKeyBytes = keyPair.getPublic().getEncoded(); 
            FileOutputStream fos = new FileOutputStream(PUBLIC_KEY_PATH);  
            fos.write(publicKeyBytes);  
            fos.close(); 
            byte[] privateKeyBytes = keyPair.getPrivate().getEncoded(); 
            fos = new FileOutputStream(PRIVATE_KEY_PATH);  
            fos.write(privateKeyBytes);  
            fos.close(); 

    }
    public static PublicKey getPublicKey(String filename) throws Exception { 
        File f = new File(filename); 
        FileInputStream fis = new FileInputStream(f);  
        DataInputStream dis = new DataInputStream(fis); 
        byte[] keyBytes = new byte[(int)f.length()];
        dis.readFully(keyBytes);  
        dis.close();
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes); 
        KeyFactory kf = KeyFactory.getInstance(ALGORITHM);  
        return kf.generatePublic(spec); 
    } 
    public static PrivateKey getPrivateKey(String filename)throws Exception { 
        File f = new File(filename); 
        FileInputStream fis = new FileInputStream(f); 
        DataInputStream dis = new DataInputStream(fis); 
        byte[] keyBytes = new byte[(int)f.length()]; 
        dis.readFully(keyBytes); 
        dis.close(); 
        PKCS8EncodedKeySpec spec =new PKCS8EncodedKeySpec(keyBytes); 
        KeyFactory kf = KeyFactory.getInstance(ALGORITHM); 
        return kf.generatePrivate(spec); 
      } 

   //base64编码公钥
    public static String getPublicKeyEn64(PublicKey pubkey) {
    	byte[] pubsrc=pubkey.getEncoded();
    	String pubkeystr=Base64.encode(pubsrc);
    	return pubkeystr;
    }
    //base64编码私钥
    
    public static String getPrivateKeyEn64(PrivateKey prikey) {
    	byte[] prisrc=prikey.getEncoded();
    	String prikeystr=Base64.encode(prisrc);
    	return prikeystr;
    }
    //从base64编码的公钥恢复公钥
    public static PublicKey getPulbickeyDE64(String key_base64) throws Exception{
        byte[] pb = Base64.decode(key_base64);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pb);
        KeyFactory  keyfactory = KeyFactory.getInstance(ALGORITHM);
        return keyfactory.generatePublic(keySpec);
    }
    //从base64编码的私钥恢复私钥
    public static PrivateKey getPrivatekeyDe64(String key_base64) throws Exception{
        byte[] pb = Base64.decode(key_base64);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pb);
        KeyFactory  keyfactory = KeyFactory.getInstance(ALGORITHM);
        return keyfactory.generatePrivate(keySpec);
    }
    /** 执行加密操作 */
    public static String encrypt(Key key,String source) throws Exception{
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODEL);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] srcbyte=source.getBytes();
        byte[] ciphertext = cipher.doFinal(srcbyte);
        String enstr=Base64.encode(ciphertext);
        return enstr;
    }
    /** 执行解密操作 */
    public static String decrypt(Key key,String stren64) throws Exception{
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODEL);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] enstr=Base64.decode(stren64);
        byte[] source = cipher.doFinal(enstr);
        String dersastr= new String(source);
        return dersastr;
    }
}
