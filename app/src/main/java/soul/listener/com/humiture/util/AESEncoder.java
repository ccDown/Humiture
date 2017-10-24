package soul.listener.com.humiture.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import soul.listener.com.humiture.util.base64.BASE64Decoder;
import soul.listener.com.humiture.util.base64.BASE64Encoder;


/**
 * @description aes加密工具
 */
public class AESEncoder {

    public static final String KEY_ALGORITHM = "AES";
    public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    /*
     * 加密用的Key 可以用26个字母和数字组成 此处使用AES-128-CBC加密模式，key需要为16位。
     */
    private static String aeskey = "1102130405061708";
    private static String ivParameter = "1102130405061708";

    /**
     * 加密
     * @param data
     * @return
     */
    public static String encrypt(String data) {
        return encrypt(data, aeskey);
    }

    public static String encrypt(String data, String aeskey) {
        //		Cipher cipher = null;
        //		try {
        //			Key key = new SecretKeySpec(aeskey.getBytes("utf-8"), KEY_ALGORITHM);
        //			cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        //			cipher.init(Cipher.ENCRYPT_MODE, key);
        //			return Base64.encodeToString(cipher.doFinal(data.getBytes()),Base64.DEFAULT);
        //		} catch (Exception e) {
        //			e.printStackTrace();
        //			return null;
        //		}

        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] raw = aeskey.getBytes();
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            byte[] encrypted = cipher.doFinal(data.getBytes("utf-8"));
            return new BASE64Encoder().encode(encrypted);// 此处使用BASE64做转码。
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 解密
     * @param data
     * @return
     */
    public static String decrypt(String data) {
        return decrypt(data, aeskey);
    }

    public static String decrypt(String data, String aeskey) {
        try {
            byte[] raw = aeskey.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(data);// 先用base64解密
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, "utf-8");
            return originalString;
        } catch (Exception ex) {
            return null;
        }
    }
}
