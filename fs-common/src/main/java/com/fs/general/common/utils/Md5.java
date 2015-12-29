package com.fs.general.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消息摘要加密
 * <p>
 * SHA+Hex
 *
 * @author echo
 *
 */
public abstract class Md5 {
	
	/** 明文编码 */
	private static final String ENCODING = "UTF8";
	
	/** 加密算法 */
	private static final String PROVIDER = "MD5";
	
	private static final Logger log = LoggerFactory.getLogger(Md5.class);
	
	private Md5() {
		// do nothing
	}
	private static final char[] HEX = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

    public static char[] encode(byte[] bytes) {
        final int nBytes = bytes.length;
        char[] result = new char[2*nBytes];

        int j = 0;
        for (int i=0; i < nBytes; i++) {
            // Char for top 4 bits
            result[j++] = HEX[(0xF0 & bytes[i]) >>> 4 ];
            // Bottom 4
            result[j++] = HEX[(0x0F & bytes[i])];
        }

        return result;
    }

	/**
	 * 获得明文摘要信息
	 * @param message
	 * @return 加密成功时，返回摘要信息，加密失败时直接返回明文。
	 */
	public static final String messageDigest(String message) {
		String digest = null;
		try {
			final byte[] plainText = message.getBytes(ENCODING);
			MessageDigest messageDigest = MessageDigest.getInstance(PROVIDER);
			messageDigest.update(plainText);
			char[] charBuff=  encode(messageDigest.digest());
			StringBuilder sb = new StringBuilder(charBuff.length);
			for (char c : charBuff) {
	            sb.append(c);
            }
			digest = sb.toString();
		} catch (UnsupportedEncodingException e) {
			log.error("加密失败！", e);
			digest = message;
		} catch (NoSuchAlgorithmException e) {
			log.error("加密失败！", e);
			digest = message;
		}
		return digest;
	}
	
	public static void main(String args[])
	{
		System.out.println(Md5.messageDigest("111111"));
	}
}
