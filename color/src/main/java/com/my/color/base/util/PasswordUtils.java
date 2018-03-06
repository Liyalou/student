package com.my.color.base.util;

import java.security.MessageDigest;

import org.springframework.util.StringUtils;

public class PasswordUtils
{

    private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public static String SHA1(String password, String phone)
    {
        String result = null;
        if (StringUtils.hasText(password) && StringUtils.hasText(phone))
        {
            try
            {
                MessageDigest digest = MessageDigest.getInstance("SHA-1");
                digest.update(password.getBytes("UTF-8"));
                byte[] messageDigest = digest.digest(phone.getBytes("UTF-8"));
                int l = messageDigest.length;
                char[] out = new char[l << 1];
                for (int i = 0, j = 0; i < l; i++)
                {
                    out[j++] = DIGITS[(0xF0 & messageDigest[i]) >>> 4];
                    out[j++] = DIGITS[0x0F & messageDigest[i]];
                }
                result = new String(out);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
       //System.out.println(PasswordUtils.SHA1("123456", "18224489542"));
    	System.out.println(UUIDUtils.getUUID());
    }
}