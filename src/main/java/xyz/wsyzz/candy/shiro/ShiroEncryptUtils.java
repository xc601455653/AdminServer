package xyz.wsyzz.candy.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import xyz.wsyzz.candy.config.ShiroConfiguration;

/**
 * Created by xucan on 2020/3/5.
 */
public class ShiroEncryptUtils {

    /**
     * 用来给密码加密，和shiro的密码加密器一致算法
     * @param password  密码明文
     * @param salt 当做盐的字符串，目前是用户名
     * @return
     */
    public static String encryptPassword(String password, String salt) {
        return new SimpleHash(ShiroConfiguration.HASHALGORITHMNAME, password, ByteSource.Util.bytes(salt), ShiroConfiguration.HASHITERATIONS).toHex();
    }
}
