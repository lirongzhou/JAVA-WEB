package com.mantoto.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * 数据加密
 * @author li rong zhou
 *创建时间  2016年8月2日 上午10:31:27
 */
public class Encryption {
	
	public enum Algorithmic{
		MD5,SHA
	} 
	/**
	 * 数据加密
	 * @param source 
	 * @param algorithmic MD5,SHA 两种加密方式
	 * @return
	 */
    public static String messageDigestEncryption(String source, Algorithmic algorithmic) {
        // 用来将字节转换成 16 进制表示的字符
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        
        StringBuilder sb = new StringBuilder();
        MessageDigest messageDigest;
        try {
        	if(algorithmic.equals(Algorithmic.SHA)){
        		 messageDigest = MessageDigest.getInstance("SHA");
        	}else messageDigest = MessageDigest.getInstance("MD5");
         
          messageDigest.update(source.getBytes());
         
          byte[] encryptStr = messageDigest.digest();
          for (int i = 0; i < encryptStr.length; i++) {
            int iRet = encryptStr[i];
            if (iRet < 0) {
              iRet += 256;
            }
            int iD1 = iRet / 16;
            int iD2 = iRet % 16;
            sb.append(hexDigits[iD1] + "" + hexDigits[iD2]);
          }
          return sb.toString();
        } catch (NoSuchAlgorithmException e) {
          e.printStackTrace();
        }
        return null;
      }
}
