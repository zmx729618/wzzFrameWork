package org.wzz.test.string;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class TestString {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		System.out.println(System.getProperty("java.io.tmpdir")); 
		
		String string = URLEncoder.encode("你好", "GBK");
		
		System.out.println(string);
		
		String str2 = "%E4%BD%A0%E5%A5%BD";
		
		String str2Decode = URLDecoder.decode(str2, "UTF-8");
		
		System.out.println(str2Decode);
		
	}

}
