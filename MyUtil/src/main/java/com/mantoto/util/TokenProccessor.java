package com.mantoto.util;

import java.util.Random;

import sun.misc.BASE64Encoder;

public class TokenProccessor {

    /*
     *单例设计模式（保证类的对象在内存中只有一个）
     *1、把类的构造函数私有
     *2、自己创建一个类的对象
     *3、对外提供一个公共的方法，返回类的对象
     */
    private TokenProccessor(){}
    
    private static final TokenProccessor instance = new TokenProccessor();
    
    /**
     * 返回类的对象
     * @return
     */
    public static TokenProccessor getInstance(){
        return instance;
    }
    
    /**
     * 生成Token
     * Token：Nv6RRuGEVvmGjB+jimI/gw==
     * @return
     */
    public String makeToken(){  //checkException
    	String token=	Encryption.messageDigestEncryption((System.currentTimeMillis() + new Random().nextInt(999999999)) + "",Encryption.Algorithmic.MD5 );
    	BASE64Encoder encoder = new BASE64Encoder();
    	token=  encoder.encode(token.getBytes());
    	char[] chars=token.toCharArray();
    	char c;
    	for(int i=0;i<chars.length;i++){
    		c=chars[i];
    		chars[i]=chars[chars.length-i-1];
    		chars[chars.length-i-1]=c;
    		if(i>=chars.length-i-1)break;
    	}
    	c=chars[12];
    	chars[12]=chars[22];
    	chars[22]=c;
    	token=new String(chars);	
    	return token;
    }
   
}