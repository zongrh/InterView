package com.zon.interview.utils;


import com.rt.BASE64Decoder;
import com.rt.BASE64Encoder;

/**
 * BASE64加解密
 * 
 * @author leo $Date：2014-9-3 上午08:51:06
 */
public class BASE64Util {

	/**
	 * BASE64加密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 *             $Date：2014-9-3 上午08:52:30
	 */
	public static String encryptBASE64(String key) throws Exception {
		return (new BASE64Encoder()).encodeBuffer(key.getBytes("utf-8"));
	}

	/**
	 * BASE64解密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 *             $Date：2014-9-3 上午08:52:25
	 */
	public static String decryptBASE64(String key) throws Exception {
		return new String((new BASE64Decoder()).decodeBuffer(key), "utf-8");
	}


}
