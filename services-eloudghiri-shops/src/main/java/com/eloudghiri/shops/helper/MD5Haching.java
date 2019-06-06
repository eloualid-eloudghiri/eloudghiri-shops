package com.eloudghiri.shops.helper;

import java.security.MessageDigest;

public class MD5Haching {

    public static String hachingString(String item)
    {
        try {
            MessageDigest md5HashCreator = MessageDigest.getInstance("MD5");

            byte [] md5Bytes = md5HashCreator.digest(item.getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder(md5Bytes.length * 2);

            for (byte b : md5Bytes)
                sb.append(String.format("%02x", b & 0xff));

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
