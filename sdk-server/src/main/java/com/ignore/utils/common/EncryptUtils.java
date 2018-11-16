package com.ignore.utils.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 18:41 2018/11/15
 */
public class EncryptUtils {
    private static final Logger logger = LogManager.getLogger();

    private EncryptUtils() {
    }

    /**
     * AES（对称）加密为base64code
     *
     * @param encryptKey 加密密钥
     * @return 加密后的base64code
     * @throws Exception
     */
    public static String aesEncrypt(String plain , String encryptKey) {
        byte[] content = plain.getBytes(CommonCharSet.CHARSET_UTF8);
        return base64Encode(aesToByte(content , encryptKey , Cipher.ENCRYPT_MODE));
    }

    /**
     * AES（对称）解密base64code
     *
     * @param decryptKey 解密密钥
     * @return 解密后的String
     * @throws Exception
     */
    public static String aesDecrypt(String cipher , String decryptKey) {
        byte[] content = Base64.getDecoder().decode(cipher);
        return new String(aesToByte(content , decryptKey , Cipher.DECRYPT_MODE));
    }

    /**
     * 加密或解密为byte[] 解密时content base64code
     *
     * @param content 需加密或解密的内容
     * @param key     加密或解密的key
     * @param type    加密或解密
     * @return 加密或解密之后的byte[]
     * @throws Exception
     */
    private static byte[] aesToByte(byte[] content , String key , int type) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom secure = SecureRandom.getInstance("SHA1PRNG");
            // 这种写法才能兼容window和linux的jvm
            secure.setSeed(key.getBytes());
            kgen.init(128 , secure);
            byte[] keyCode = kgen.generateKey().getEncoded();

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(type , new SecretKeySpec(keyCode , "AES"));
            return cipher.doFinal(content);
        } catch (Exception e) {
            logger.error("aesToByte failed" , e);
            return new byte[0];
        }
    }

    /**
     * 生成md5
     *
     * @param plain 明文
     * @return 密文
     */
    public static String md5(String plain) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digit = md5.digest(plain.getBytes(CommonCharSet.CHARSET_UTF8));
            return bytesToHex(digit);
        } catch (NoSuchAlgorithmException e) {
            logger.error("No such algorithm: md5" , e);
            return null;
        }
    }

    /**
     * 把数组每一字节换成16进制连成md5字符串
     *
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuilder md5str = new StringBuilder();
        int digital;
        for (int i = 0; i < bytes.length; i++) {
            digital = bytes[i];
            if (digital < 0) {
                digital += 256;
            }
            if (digital < 16) {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString();
    }

    /**
     * base64Encode
     *
     * @param plain 明文
     * @return 密文
     */
    public static String base64Encode(String plain) {
        return base64Encode(plain.getBytes(CommonCharSet.CHARSET_UTF8));
    }

    /**
     * base64Encode
     *
     * @param plain
     * @return
     */
    public static String base64Encode(byte[] plain) {
        return Base64.getEncoder().encodeToString(plain);
    }

    /**
     * @param cipher 密文
     * @return 明文
     */
    public static String base64Decode(String cipher) {
        return new String(Base64.getDecoder().decode(cipher));
    }
}
